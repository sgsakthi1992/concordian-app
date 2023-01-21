# Get Employees
To get the list of employees

### [Get Employees endpoint /employee](- "get employees")

#### Setup data
| [ ][setup] [Id](- "#id") | [Name](- "#name") | [Email](- "#email") |
|--------------------------|-------------------|---------------------|
| 1                        | john.lennon       | j@gmail.com         |
| 2                        | ringo.starr       | r@gmail.com         |

[setup]: - "setUpEmployees(#id, #name, #email)"

#### Expected data
| [][result] [Id](- "?=#result.id") | [Name](- "?=#result.name") | [Email](- "?=#result.email") |
|-----------------------------------|----------------------------|------------------------------|
| 1                                 | john.lennon                | j@gmail.com                  |
| 2                                 | ringo.starr                | r@gmail.com                  |

[result]: - "c:verify-rows=#result:testEmployeeEndpoint() c:matchStrategy=BestMatch"