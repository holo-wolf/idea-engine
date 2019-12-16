/* *********************************************************************************************************************
 * Copyright (c) 2019 Allan D. Boswell
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this program.
 * If not, see <https://www.gnu.org/licenses/>.
 * ****************************************************************************************************************** */
package ideaengine.logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * The Logger class handles the overall logging system for the IDEA engine. Ensure that you have a resources directory
 * located in 'src/main' along with a 'logs' directory located in the 'resources' directory. It may or may not
 * automatically create these directories depending on your operating system.
 *
 * <d>
 *     <dt><span class="strong">date</span></dt><dd>Stores the current date and time into this variable.</dd>
 *     <dt><span class="strong">dateFormat</span></dt><dd>Formats the current date and time into a readable format.</dd>
 *     <dt><span class="strong">strDate</span></dt><dd>Formats the current date and time into a string.</dd>
 *     <dt><span class="strong">INFO</span></dt><dd>INFO label is an all-purpose, general logging event.</dd>
 *     <dt><span class="strong">IDEA</span></dt><dd>IDEA label is an event that is being handled by IDEA.</dd>
 *     <dt><span class="strong">Logger()</span></dt><dd>Constructor that outputs a simple test log file.</dd>
 *     <dt><span class="strong">void databaseFirstConnect()</span></dt><dd>Logs database's first connection.</dd>
 *     <dt><span class="strong">void databaseConnected()</span></dt><dd>Logs database's successful connection.</dd>
 *     <dt><span class="strong">void databaseDisconnect()</span></dt><dd>Logs database's first disconnection.</dd>
 *     <dt><span class="strong">void databaseUserAdded()</span></dt><dd>Logs when a user is added to the database.</dd>
 *     <dt><span class="strong">void databaseServerAdded()</span></dt><dd>Logs when a server is added to the DB.</dd>
 *     <dt><span class="strong">void discordConnected()</span></dt><dd>Logs attempt at connecting to Discord.</dd>
 *     <dt><span class="strong">void discordUserAdded()</span></dt><dd>Logs when a Discord user is added to DB.</dd>
 *     <dt><span class="strong">void discordServerAdded()</span></dt><dd>Logs when a Discord server is added to DB.</dd>
 *     <dt><span class="strong">String getPath()</span></dt><dd>Returns the path to the logs directory.</dd>
 *     <dt><span class="strong">String getExtension()</span></dt><dd>Returns the extension for all log files.</dd>
 *     <dt><span class="strong">String getTestLog</span></dt><dd>Returns the file name of the test log.</dd>
 *     <dt><span class="strong">String getDatabaseLog</span></dt><dd>Returns the file name of the database log.</dd>
 *     <dt><span class="strong">String getDiscordLog</span></dt><dd>Returns the file name of the Discord log.</dd>
 *     <dt><span class="strong">String updateDate()</span></dt><dd>Updates the current date and time.</dd>
 * </d>
 */
public class Logger implements LogADT {
    // Get a string format of the current date and time (this will need to be updated via a method each time).
    private Date date = Calendar.getInstance().getTime();
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    private String strDate = dateFormat.format(date);

    // Signal where the log message is coming from.
    private final String INFO = " [INFO]: ";
    private final String IDEA = " [IDEA]: ";

    /**
     * The Logger constructor initializes the logging system and outputs a simple test log file to ensure that writing
     * to files is achievable on this operating system. Set the parameter to FALSE if you do not want to run a test log
     * file check.
     *
     * @param check boolean parameter to determine if a test log should be generated
     * @throws IOException unable to write file and/or the appropriate directory does not exist
     */
    public Logger(boolean check) throws IOException {
        if (check) {
            String TEST_LOG = getPath() + getTestLog() + getExtension();  // test_log.txt

            BufferedWriter file = new BufferedWriter(new FileWriter(TEST_LOG));
            file.write(strDate + INFO + "Test log successfully generated.");
            file.close();
        }
    }

    /**
     * This method logs a successful first-time connection attempt to the Idea Network (database that is powered by
     * PostgreSQL 12).
     *
     * @throws IOException unable to write file and/or the appropriate directory does not exist
     */
    public void databaseFirstConnect() throws IOException {
        strDate = updateDate();
        String DATABASE_LOG = getPath() + getDatabaseLog() + getExtension();  // dbms/database.txt

        BufferedWriter file = new BufferedWriter(new FileWriter(DATABASE_LOG));
        file.write(strDate + INFO + "Connected to the Idea Network.");
        file.close();
    }

    /**
     * This method logs a successful first-time disconnect attempt from the Idea Network (database that is powered by
     * PostgreSQL 12).
     *
     * @throws IOException unable to write file and/or the appropriate directory does not exist
     */
    public void databaseDisconnect() throws IOException {
        strDate = updateDate();
        String DATABASE_LOG = getPath() + getDatabaseLog() + getExtension();  // dbms/database.txt

        FileWriter db = new FileWriter(DATABASE_LOG, true);
        BufferedWriter file = new BufferedWriter(db);
        file.write("\n" + strDate + INFO + "Disconnected from the Idea Network.");
        file.close();
    }

    /**
     * This method logs a successful connection to the Idea Network (database that is powered by PostgreSQL 12).
     *
     * @throws IOException unable to write file and/or the appropriate directory does not exist
     */
    public void databaseConnected() throws IOException {
        strDate = updateDate();
        String DATABASE_LOG = getPath() + getDatabaseLog() + getExtension();  // dbms/database.txt

        FileWriter db = new FileWriter(DATABASE_LOG, true);
        BufferedWriter file = new BufferedWriter(db);
        file.write("\n" + strDate + INFO + "Connected to the Idea Network.");
        file.close();
    }

    /**
     * This method logs a successful attempt at adding a user from any given service into the Idea Network database.
     *
     * @param userID user identification string from any given service
     * @param table name of table in database
     * @throws IOException unable to write file and/or the appropriate directory does not exist
     */
    public void databaseUserAdded(String userID, String table) throws IOException {
        strDate = updateDate();
        String DATABASE_LOG = getPath() + getDatabaseLog() + getExtension();  // dbms/database.txt

        FileWriter db = new FileWriter(DATABASE_LOG, true);
        BufferedWriter file = new BufferedWriter(db);
        file.write("\n" + strDate + IDEA + "Added " + userID + " to the " + table + " table!");
        file.close();
    }

    /**
     * This method logs a successful attempt at adding a server from any given service into the Idea Network database.
     *
     * @param serverID server identification string from any given service
     * @param table name of table in database
     * @throws IOException unable to write file and/or the appropriate directory does not exist
     */
    public void databaseServerAdded(String serverID, String table) throws IOException {
        strDate = updateDate();
        String DATABASE_LOG = getPath() + getDatabaseLog() + getExtension();  // dbms/database.txt

        FileWriter db = new FileWriter(DATABASE_LOG, true);
        BufferedWriter file = new BufferedWriter(db);
        file.write("\n" + strDate + IDEA + "Added " + serverID + " to the " + table + " table!");
        file.close();
    }

    /**
     * This method logs a first-time attempt at connecting with Discord. The attempt, itself, may or may not work
     * depending on how you've configured everything in the 'discord' package.
     *
     * @throws IOException unable to write file and/or the appropriate directory does not exist
     */
    public void discordConnected() throws IOException {
        strDate = updateDate();
        String DISCORD_LOG = getPath() + getDiscordLog() + getExtension();  // discord/discord.txt

        BufferedWriter file = new BufferedWriter(new FileWriter(DISCORD_LOG));
        file.write(strDate + INFO + "Establishing a connection to Discord...");
        file.close();
    }

    /**
     * This method logs a successful attempt at when a Discord user is added into the Idea Network database.
     *
     * @param userID Discord user identification string
     * @throws IOException unable to write file and/or the appropriate directory does not exist
     */
    public void discordUserAdded(String userID) throws IOException {
        strDate = updateDate();
        String DISCORD_LOG = getPath() + getDiscordLog() + getExtension();  // discord/discord.txt

        FileWriter db = new FileWriter(DISCORD_LOG, true);
        BufferedWriter file = new BufferedWriter(db);
        file.write("\n" + strDate + IDEA + "Added " + userID + " (user) to the Idea Network!");
        file.close();
    }

    /**
     * This method logs a successful attempt at when a Discord server is added into the Idea Network database.
     *
     * @param serverID Discord server identification string
     * @throws IOException unable to write file and/or the appropriate directory does not exist
     */
    public void discordServerAdded(String serverID) throws IOException {
        strDate = updateDate();
        String DISCORD_LOG = getPath() + getDiscordLog() + getExtension();  // discord/discord.txt

        FileWriter db = new FileWriter(DISCORD_LOG, true);
        BufferedWriter file = new BufferedWriter(db);
        file.write("\n" + strDate + IDEA + "Added " + serverID + " (server) to the Idea Network!");
        file.close();
    }

    /**
     * This method returns the path to the logs directory.
     *
     * @return logs directory path
     */
    public String getPath() {
        return LOG_PATH;
    }

    /**
     * This method returns the extension for any given log file.
     *
     * @return extension for any log file
     */
    public String getExtension() {
        return EXT;
    }

    /**
     * This method returns the name for the test log file.
     *
     * @return test log file name
     */
    public String getTestLog() {
        return testLog;
    }

    /**
     * This method returns the name for the database log file.
     *
     * @return database log file name
     */
    public String getDatabaseLog() {
        return databaseLog;
    }

    /**
     * This method returns the name for the Discord log file.
     *
     * @return Discord log file name
     */
    public String getDiscordLog() {
        return discordLog;
    }

    /**
     * This method updates the current date and time for logging purposes.
     *
     * @return updated date and time in string format
     */
    private String updateDate() {
        date = Calendar.getInstance().getTime();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

        return dateFormat.format(date);
    }
}
