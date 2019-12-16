# IDEA Engine #
IDEA is an artificially intelligent program which operates as a virtual assistant for a variety of different functions 
and tasks. The engine is developed using [Java SE 8](https://docs.oracle.com/javase/8/docs/) and utilizes 
[PostgreSQL 12](https://www.postgresql.org/docs/12/index.html) for its database management system.

## Installation ##
If you are interested in contributing to the development of this project, you must install the IDEA Engine locally. It 
is _recommended_ to use [JetBrain's IntelliJ IDEA](https://www.jetbrains.com/idea/) integrated development environment 
although you are free to use any other IDE (or lack thereof) of your choosing. The following steps assume that you are 
using the aforementioned IDE. ___This repository also assumes that you understand how to install any prerequisite 
software needed to properly configure the IDEA Engine.___

##### Clone Repository #####
- __Make sure to have [Git](https://git-scm.com/) installed prior to cloning this repository.__

##### Configure Logging System #####
- __If you are using an operating system other than [Windows 10](https://www.microsoft.com/en-us/windows/features), you 
may have to adjust the [package](src/main/java/ideaengine/logging/) in order for the IDEA Engine to read and write log 
files onto your system.__

##### Configure IDEA Network #####
- __Make sure to have [PostgreSQL](https://www.postgresql.org/) installed prior to setting up the IDEA Network.__
    - _The following environment variables should be considered: <code>PostgreSQL_IDEA_JDBC</code>, 
    <code>PostgreSQL_IDEA_ROLE</code>, and <code>PostgreSQL_IDEA_LOGIN</code>. These will be initialized as we 
    set up the IDEA Network_.

##### Configure Discord Bot #####
- __Make sure to have your Discord bot's [token](https://discordapp.com/developers/applications/) ready as you'll need 
this in order for your bot to log into the service. You should also (probably) set up a server so that you can test the 
bot in private.__
    - _Be sure to initialize the <code>DISCORD_IDEA_TOKEN</code> environment variable with your Discord bot's token._

## License ##
See [COPYING](COPYING) for licensing details.
