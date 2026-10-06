# USE CASE: 4 Report Generation

## CHARACTERISTIC INFORMATION

### Goal in Context

A report of one of the four types: (Country, City, Capital City and Population) needs to be generated.

### Scope

Organisation

### Level

Primary task

### Preconditions

Database contains necessary information. The properties for a report have been defined.

### Success End Condition

A report of the correct type containing the defined data is generated and displayed.

### Failed End Condition

No report is generated and no information is displayed.

### Primary Actor

Employee

### Trigger

A report of data from the database is needed by the organisation.

## MAIN SUCCESS SCENARIO

1. A report is defined by the organisation
2. An employee requests the data using the application
3. A report of the correct type containing the defined data is generated.
4. This report is displayed.

## EXTENSIONS

1a. Country report is defined:

1. Follow country report sub-variation.

1b. City report is defined:

1. Follow city report sub-variation.

1c. Capital city report is defined:

1. Follow city report sub-variation.

1d. Population report is defined:

1. Follow population report sub-variation.

## SUB-VARIATIONS

*put here the sub-variations that will cause eventual branching in the scenario

1. Country report. These columns are needed: Name, Country, Population.
2. City report. These columns are needed: Name, Country, District, Population
3. Capital City report. These columns are needed: Name, Country, Population


4. Population report. The information of the continent/region/city is requested: Name, Population, Population living in cities (including a %), Population living outside cities (including a %).

## SCHEDULE

**DUE DATE**: *Code review 4*