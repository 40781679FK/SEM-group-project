package com.napier.sem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 */
public class App
{
    public static void main(String[] args) throws InterruptedException {
        String url = "jdbc:mysql://db:3306/world?allowPublicKeyRetrieval=true&useSSL=false";
        String username = "root";
        String password = "example";

        Thread.sleep(30000);
        try (Connection connection = DriverManager.getConnection(url, username, password))
        {
            System.out.println("Connected to MySQL successfully!");

            try (Statement statement = connection.createStatement())
            {
                System.out.println("\n1. All countries in the world");
                try (ResultSet result = statement.executeQuery(
                        "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS Capital " +
                                "FROM country LEFT JOIN city ON country.Capital = city.ID " +
                                "ORDER BY country.Population DESC"))
                {
                    while (result.next())
                        System.out.println(result.getString("Code") + " | " + result.getString("Name") + " | " +
                                result.getString("Continent") + " | " + result.getString("Region") + " | " +
                                result.getInt("Population") + " | " + result.getString("Capital"));
                }

                System.out.println("\n2. All countries in Asia");
                try (ResultSet result = statement.executeQuery(
                        "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS Capital " +
                                "FROM country LEFT JOIN city ON country.Capital = city.ID " +
                                "WHERE country.Continent = 'Asia' ORDER BY country.Population DESC"))
                {
                    while (result.next())
                        System.out.println(result.getString("Code") + " | " + result.getString("Name") + " | " +
                                result.getString("Continent") + " | " + result.getString("Region") + " | " +
                                result.getInt("Population") + " | " + result.getString("Capital"));
                }

                System.out.println("\n3. All countries in the Caribbean");
                try (ResultSet result = statement.executeQuery(
                        "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS Capital " +
                                "FROM country LEFT JOIN city ON country.Capital = city.ID " +
                                "WHERE country.Region = 'Caribbean' ORDER BY country.Population DESC"))
                {
                    while (result.next())
                        System.out.println(result.getString("Code") + " | " + result.getString("Name") + " | " +
                                result.getString("Continent") + " | " + result.getString("Region") + " | " +
                                result.getInt("Population") + " | " + result.getString("Capital"));
                }

                System.out.println("\n4. Top 5 countries in the world");
                try (ResultSet result = statement.executeQuery(
                        "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS Capital " +
                                "FROM country LEFT JOIN city ON country.Capital = city.ID " +
                                "ORDER BY country.Population DESC LIMIT 5"))
                {
                    while (result.next())
                        System.out.println(result.getString("Code") + " | " + result.getString("Name") + " | " +
                                result.getString("Continent") + " | " + result.getString("Region") + " | " +
                                result.getInt("Population") + " | " + result.getString("Capital"));
                }

                System.out.println("\n5. Top 3 countries in Europe");
                try (ResultSet result = statement.executeQuery(
                        "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS Capital " +
                                "FROM country LEFT JOIN city ON country.Capital = city.ID " +
                                "WHERE country.Continent = 'Europe' ORDER BY country.Population DESC LIMIT 3"))
                {
                    while (result.next())
                        System.out.println(result.getString("Code") + " | " + result.getString("Name") + " | " +
                                result.getString("Continent") + " | " + result.getString("Region") + " | " +
                                result.getInt("Population") + " | " + result.getString("Capital"));
                }

                System.out.println("\n6. Top 3 countries in the Caribbean");
                try (ResultSet result = statement.executeQuery(
                        "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS Capital " +
                                "FROM country LEFT JOIN city ON country.Capital = city.ID " +
                                "WHERE country.Region = 'Caribbean' ORDER BY country.Population DESC LIMIT 3"))
                {
                    while (result.next())
                        System.out.println(result.getString("Code") + " | " + result.getString("Name") + " | " +
                                result.getString("Continent") + " | " + result.getString("Region") + " | " +
                                result.getInt("Population") + " | " + result.getString("Capital"));
                }

                System.out.println("\n7. All cities in the world");
                try (ResultSet result = statement.executeQuery(
                        "SELECT city.Name, country.Name AS Country, city.District, city.Population " +
                                "FROM city JOIN country ON city.CountryCode = country.Code ORDER BY city.Population DESC"))
                {
                    while (result.next())
                        System.out.println(result.getString("Name") + " | " + result.getString("Country") + " | " +
                                result.getString("District") + " | " + result.getInt("Population"));
                }

                System.out.println("\n8. All cities in Oceania");
                try (ResultSet result = statement.executeQuery(
                        "SELECT city.Name, country.Name AS Country, city.District, city.Population " +
                                "FROM city JOIN country ON city.CountryCode = country.Code " +
                                "WHERE country.Continent = 'Oceania' ORDER BY city.Population DESC"))
                {
                    while (result.next())
                        System.out.println(result.getString("Name") + " | " + result.getString("Country") + " | " +
                                result.getString("District") + " | " + result.getInt("Population"));
                }

                System.out.println("\n9. All cities in the Caribbean");
                try (ResultSet result = statement.executeQuery(
                        "SELECT city.Name, country.Name AS Country, city.District, city.Population " +
                                "FROM city JOIN country ON city.CountryCode = country.Code " +
                                "WHERE country.Region = 'Caribbean' ORDER BY city.Population DESC"))
                {
                    while (result.next())
                        System.out.println(result.getString("Name") + " | " + result.getString("Country") + " | " +
                                result.getString("District") + " | " + result.getInt("Population"));
                }

                System.out.println("\n10. All cities in Japan");
                try (ResultSet result = statement.executeQuery(
                        "SELECT city.Name, country.Name AS Country, city.District, city.Population " +
                                "FROM city JOIN country ON city.CountryCode = country.Code " +
                                "WHERE country.Name = 'Japan' ORDER BY city.Population DESC"))
                {
                    while (result.next())
                        System.out.println(result.getString("Name") + " | " + result.getString("Country") + " | " +
                                result.getString("District") + " | " + result.getInt("Population"));
                }

                System.out.println("\n11. All cities in the district of Kabol");
                try (ResultSet result = statement.executeQuery(
                        "SELECT city.Name, country.Name AS Country, city.District, city.Population " +
                                "FROM city JOIN country ON city.CountryCode = country.Code " +
                                "WHERE city.District = 'Kabol' ORDER BY city.Population DESC"))
                {
                    while (result.next())
                        System.out.println(result.getString("Name") + " | " + result.getString("Country") + " | " +
                                result.getString("District") + " | " + result.getInt("Population"));
                }

                System.out.println("\n12. Top 5 cities in the world");
                try (ResultSet result = statement.executeQuery(
                        "SELECT city.Name, country.Name AS Country, city.District, city.Population " +
                                "FROM city JOIN country ON city.CountryCode = country.Code " +
                                "ORDER BY city.Population DESC LIMIT 5"))
                {
                    while (result.next())
                        System.out.println(result.getString("Name") + " | " + result.getString("Country") + " | " +
                                result.getString("District") + " | " + result.getInt("Population"));
                }

                System.out.println("\n13. Top 3 cities in Africa");
                try (ResultSet result = statement.executeQuery(
                        "SELECT city.Name, country.Name AS Country, city.District, city.Population " +
                                "FROM city JOIN country ON city.CountryCode = country.Code " +
                                "WHERE country.Continent = 'Africa' ORDER BY city.Population DESC LIMIT 3"))
                {
                    while (result.next())
                        System.out.println(result.getString("Name") + " | " + result.getString("Country") + " | " +
                                result.getString("District") + " | " + result.getInt("Population"));
                }

                System.out.println("\n14. Top 3 cities in the Caribbean");
                try (ResultSet result = statement.executeQuery(
                        "SELECT city.Name, country.Name AS Country, city.District, city.Population " +
                                "FROM city JOIN country ON city.CountryCode = country.Code " +
                                "WHERE country.Region = 'Caribbean' ORDER BY city.Population DESC LIMIT 3"))
                {
                    while (result.next())
                        System.out.println(result.getString("Name") + " | " + result.getString("Country") + " | " +
                                result.getString("District") + " | " + result.getInt("Population"));
                }

                System.out.println("\n15. Top 3 cities in Japan");
                try (ResultSet result = statement.executeQuery(
                        "SELECT city.Name, country.Name AS Country, city.District, city.Population " +
                                "FROM city JOIN country ON city.CountryCode = country.Code " +
                                "WHERE country.Name = 'Japan' ORDER BY city.Population DESC LIMIT 3"))
                {
                    while (result.next())
                        System.out.println(result.getString("Name") + " | " + result.getString("Country") + " | " +
                                result.getString("District") + " | " + result.getInt("Population"));
                }

                System.out.println("\n16. Top 3 cities in Kabol");
                try (ResultSet result = statement.executeQuery(
                        "SELECT city.Name, country.Name AS Country, city.District, city.Population " +
                                "FROM city JOIN country ON city.CountryCode = country.Code " +
                                "WHERE city.District = 'Kabol' ORDER BY city.Population DESC LIMIT 3"))
                {
                    while (result.next())
                        System.out.println(result.getString("Name") + " | " + result.getString("Country") + " | " +
                                result.getString("District") + " | " + result.getInt("Population"));
                }

                System.out.println("\n17. All capital cities in the world");
                try (ResultSet result = statement.executeQuery(
                        "SELECT city.Name, country.Name AS Country, city.Population " +
                                "FROM country JOIN city ON country.Capital = city.ID ORDER BY city.Population DESC"))
                {
                    while (result.next())
                        System.out.println(result.getString("Name") + " | " + result.getString("Country") + " | " +
                                result.getInt("Population"));
                }

                System.out.println("\n18. All capital cities in Europe");
                try (ResultSet result = statement.executeQuery(
                        "SELECT city.Name, country.Name AS Country, city.Population " +
                                "FROM country JOIN city ON country.Capital = city.ID " +
                                "WHERE country.Continent = 'Europe' ORDER BY city.Population DESC"))
                {
                    while (result.next())
                        System.out.println(result.getString("Name") + " | " + result.getString("Country") + " | " +
                                result.getInt("Population"));
                }

                System.out.println("\n19. All capital cities in the Caribbean");
                try (ResultSet result = statement.executeQuery(
                        "SELECT city.Name, country.Name AS Country, city.Population " +
                                "FROM country JOIN city ON country.Capital = city.ID " +
                                "WHERE country.Region = 'Caribbean' ORDER BY city.Population DESC"))
                {
                    while (result.next())
                        System.out.println(result.getString("Name") + " | " + result.getString("Country") + " | " +
                                result.getInt("Population"));
                }

                System.out.println("\n20. Top 5 capital cities in the world");
                try (ResultSet result = statement.executeQuery(
                        "SELECT city.Name, country.Name AS Country, city.Population " +
                                "FROM country JOIN city ON country.Capital = city.ID " +
                                "ORDER BY city.Population DESC LIMIT 5"))
                {
                    while (result.next())
                        System.out.println(result.getString("Name") + " | " + result.getString("Country") + " | " +
                                result.getInt("Population"));
                }

                System.out.println("\n21. Top 3 capital cities in Asia");
                try (ResultSet result = statement.executeQuery(
                        "SELECT city.Name, country.Name AS Country, city.Population " +
                                "FROM country JOIN city ON country.Capital = city.ID " +
                                "WHERE country.Continent = 'Asia' ORDER BY city.Population DESC LIMIT 3"))
                {
                    while (result.next())
                        System.out.println(result.getString("Name") + " | " + result.getString("Country") + " | " +
                                result.getInt("Population"));
                }

                System.out.println("\n22. Top 3 capital cities in the Caribbean");
                try (ResultSet result = statement.executeQuery(
                        "SELECT city.Name, country.Name AS Country, city.Population " +
                                "FROM country JOIN city ON country.Capital = city.ID " +
                                "WHERE country.Region = 'Caribbean' ORDER BY city.Population DESC LIMIT 3"))
                {
                    while (result.next())
                        System.out.println(result.getString("Name") + " | " + result.getString("Country") + " | " +
                                result.getInt("Population"));
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("MySQL connection or report failed:");
            e.printStackTrace();
        }
    }
}