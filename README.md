# Project: reference demo


## Features: 
#### POM can be executed with different environment values
- Execution from console was never easier :) In fact "mvn clean [ -Dconfig.Dir=value | -DsuiteXmlFile=fileName ] test" can be used to execute different different tests or use different configurations. By default testng.xml is executed

#### Logging into file / on console
- Log stored under "./logs/reference_demo{env_name}.log"
Different log setup for test / dev, configured in log4j.xml file , placed under different dir

#### Screenshot created by default upon failure
- Failed test is captured by default and stored under /build/reports

#### Test data read up from external JSON file
- JSON based test data. Class name should match with the JSON file name, or overwrite with @TestDataSource annotaion at class level 

#### POM file configures the environment 
- If we want to test on different environment we can change configuration by providing different env value wich will use the referred directory as a source <config.dir>

#### test && dev enviroments are available
- Pre configured logging in case of different enviroments

