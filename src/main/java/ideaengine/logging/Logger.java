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
 *     <dt><span class="strong">String getPath()</span></dt><dd>Returns the path to the logs directory.</dd>
 *     <dt><span class="strong">String getExtension()</span></dt><dd>Returns the extension for all log files.</dd>
 *     <dt><span class="strong">String getTestLog</span></dt><dd>Returns the file name of the test log.</dd>
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
}
