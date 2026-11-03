package com.napier.sem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Locale;

/**
 *
 */
public class App
{
    private Connection con;

    public void connect(String location, int delay) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;

        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");

            try {
                Thread.sleep(delay);

                con = DriverManager.getConnection(
                        "jdbc:mysql://" + location +
                                "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root",
                        "example"
                );

                System.out.println("Successfully connected");
                break;

            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());

            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted");
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public static void main(String[] args) {
        App a = new App();

        if (args.length < 1) {
            a.connect("localhost:33060", 30000);
        } else {
            a.connect(args[0], Integer.parseInt(args[1]));
        }

        try {
            // ---------- Country reports (scope: world / continent / region, limit 0 = no limit) ----------
            a.printCountryReport("1. All countries in the world", "world", null, 0);
            a.printCountryReport("2. All countries in Asia", "continent", "Asia", 0);
            a.printCountryReport("3. All countries in the Caribbean", "region", "Caribbean", 0);
            a.printCountryReport("4. Top 5 countries in the world", "world", null, 5);
            a.printCountryReport("5. Top 3 countries in Europe", "continent", "Europe", 3);
            a.printCountryReport("6. Top 3 countries in the Caribbean", "region", "Caribbean", 3);

            // ---------- City reports (scope: world / continent / region / country / district) ----------
            a.printCityReport("7. All cities in the world", "world", null, 0);
            a.printCityReport("8. All cities in Oceania", "continent", "Oceania", 0);
            a.printCityReport("9. All cities in the Caribbean", "region", "Caribbean", 0);
            a.printCityReport("10. All cities in Japan", "country", "Japan", 0);
            a.printCityReport("11. All cities in the district of Kabol", "district", "Kabol", 0);
            a.printCityReport("12. Top 5 cities in the world", "world", null, 5);
            a.printCityReport("13. Top 3 cities in Africa", "continent", "Africa", 3);
            a.printCityReport("14. Top 3 cities in the Caribbean", "region", "Caribbean", 3);
            a.printCityReport("15. Top 3 cities in Japan", "country", "Japan", 3);
            a.printCityReport("16. Top 3 cities in Kabol", "district", "Kabol", 3);

            // ---------- Capital city reports (scope: world / continent / region) ----------
            a.printCapitalReport("17. All capital cities in the world", "world", null, 0);
            a.printCapitalReport("18. All capital cities in Europe", "continent", "Europe", 0);
            a.printCapitalReport("19. All capital cities in the Caribbean", "region", "Caribbean", 0);
            a.printCapitalReport("20. Top 5 capital cities in the world", "world", null, 5);
            a.printCapitalReport("21. Top 3 capital cities in Asia", "continent", "Asia", 3);
            a.printCapitalReport("22. Top 3 capital cities in the Caribbean", "region", "Caribbean", 3);

            // ---------- Population distribution reports ----------
            a.printPopulationDistribution("23. Population distribution by continent", "continent");
            a.printPopulationDistribution("24. Population distribution by region", "region");
            a.printPopulationDistribution("25. Population distribution by country", "country");
        }
        catch (Exception e)
        {
            System.out.println("MySQL connection or report failed:");
            e.printStackTrace();
        }
    }

    public String formatCountry(String code, String name, String continent,
                                String region, int population, String capital) {
        return code + " | " + name + " | " + continent + " | " +
                region + " | " + population + " | " + capital;
    }

    public int getCountryCount() throws SQLException {
        try (Statement statement = con.createStatement();
             ResultSet result = statement.executeQuery(
                     "SELECT COUNT(*) FROM country")) {

            result.next();
            return result.getInt(1);
        }
    }

    /**
     * Builds the WHERE part of a report query for the chosen scope.
     * Column names cannot be sent as ? placeholders, so the scope is checked
     * against this fixed list and only a known piece of SQL is ever used.
     * The value itself (e.g. 'Asia') is always sent as a ? placeholder.
     */
    private String whereClause(String scope) {
        switch (scope) {
            case "world":
                return "";
            case "continent":
                return "WHERE country.Continent = ? ";
            case "region":
                return "WHERE country.Region = ? ";
            case "country":
                return "WHERE country.Name = ? ";
            case "district":
                return "WHERE city.District = ? ";
            default:
                throw new IllegalArgumentException("Unknown report scope: " + scope);
        }
    }

    /**
     * Runs a report query. sqlStart is everything before the WHERE clause,
     * sqlEnd is the ORDER BY part. A limit of 0 (or less) means "no limit".
     */
    private ResultSet runReport(String sqlStart, String scope, String value, String sqlEnd, int limit)
            throws SQLException {
        String sql = sqlStart + whereClause(scope) + sqlEnd + (limit > 0 ? " LIMIT ?" : "");
        PreparedStatement statement = con.prepareStatement(sql);
        int parameter = 1;
        if (!scope.equals("world")) {
            statement.setString(parameter++, value);
        }
        if (limit > 0) {
            statement.setInt(parameter, limit);
        }
        statement.closeOnCompletion(); // the statement closes itself when the ResultSet is closed
        return statement.executeQuery();
    }

    /** Country report scope is world, continent or region. */
    public void printCountryReport(String title, String scope, String value, int limit) throws SQLException {
        System.out.println("\n" + title);
        try (ResultSet result = runReport(
                "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS Capital " +
                        "FROM country LEFT JOIN city ON country.Capital = city.ID ",
                scope, value, "ORDER BY country.Population DESC", limit))
        {
            while (result.next())
                System.out.println(formatCountry(result.getString("Code"), result.getString("Name"),
                        result.getString("Continent"), result.getString("Region"),
                        result.getInt("Population"), result.getString("Capital")));
        }
    }

    /** City report scope is world, continent, region, country or district. */
    public void printCityReport(String title, String scope, String value, int limit) throws SQLException {
        System.out.println("\n" + title);
        try (ResultSet result = runReport(
                "SELECT city.Name, country.Name AS Country, city.District, city.Population " +
                        "FROM city JOIN country ON city.CountryCode = country.Code ",
                scope, value, "ORDER BY city.Population DESC", limit))
        {
            while (result.next())
                System.out.println(result.getString("Name") + " | " + result.getString("Country") + " | " +
                        result.getString("District") + " | " + result.getInt("Population"));
        }
    }

    /** Capital city report: scope is world, continent or region. */
    public void printCapitalReport(String title, String scope, String value, int limit) throws SQLException {
        System.out.println("\n" + title);
        try (ResultSet result = runReport(
                "SELECT city.Name, country.Name AS Country, city.Population " +
                        "FROM country JOIN city ON country.Capital = city.ID ",
                scope, value, "ORDER BY city.Population DESC", limit))
        {
            while (result.next())
                System.out.println(result.getString("Name") + " | " + result.getString("Country") + " | " +
                        result.getInt("Population"));
        }
    }

    /**
     * Population distribution for each continent, region or country shows the total
     * population, the population living in cities and the population not living in cities.
     * City populations are totaled per country in a subquery first, so a countrys own
     * population is never counted once per city.
     */
    public void printPopulationDistribution(String title, String level) throws SQLException {
        String groupColumn;
        switch (level) {
            case "continent":
                groupColumn = "country.Continent";
                break;
            case "region":
                groupColumn = "country.Region";
                break;
            case "country":
                groupColumn = "country.Name";
                break;
            default:
                throw new IllegalArgumentException("Unknown distribution level: " + level);
        }

        System.out.println("\n" + title);
        try (Statement statement = con.createStatement();
             ResultSet result = statement.executeQuery(
                     "SELECT " + groupColumn + " AS Name, " +
                             "SUM(country.Population) AS TotalPopulation, " +
                             "SUM(IFNULL(cityTotals.CityPopulation, 0)) AS CityPopulation " +
                             "FROM country LEFT JOIN " +
                             "(SELECT CountryCode, SUM(Population) AS CityPopulation FROM city GROUP BY CountryCode) AS cityTotals " +
                             "ON country.Code = cityTotals.CountryCode " +
                             "GROUP BY " + groupColumn + " ORDER BY TotalPopulation DESC"))
        {
            while (result.next()) {
                long total = result.getLong("TotalPopulation");
                long inCities = result.getLong("CityPopulation");
                System.out.println(formatDistribution(result.getString("Name"), total, inCities));
            }
        }
    }

    /** Formats one distribution row: name , total , in cities (%) , not in cities (%). */
    public String formatDistribution(String name, long total, long inCities) {
        long notInCities = total - inCities;
        double inCitiesPercent = total == 0 ? 0 : inCities * 100.0 / total;
        double notInCitiesPercent = total == 0 ? 0 : notInCities * 100.0 / total;
        return name + " | " + total + " | " + inCities + " (" + String.format(Locale.ROOT, "%.2f", inCitiesPercent) + "%) | " +
                notInCities + " (" + String.format(Locale.ROOT, "%.2f", notInCitiesPercent) + "%)";
    }
}