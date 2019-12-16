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

/**
 * The LogADT interface provides an abstraction of the different types of variables and methods one may use in order to
 * log important details and events.
 *
 * <d>
 *     <dt><span class="strong">SEPARATOR</span></dt><dd>Appropriately separates files (reverse backslash).</dd>
 *     <dt><span class="strong">USR_PATH</span></dt><dd>Provides the path to the user directory of this project.</dd>
 *     <dt><span class="strong">LOG_PATH</span></dt><dd>Provides the path to the logs directory of this project.</dd>
 *     <dt><span class="strong">EXT</span></dt><dd>Provides the extension for any generated log file.</dd>
 *     <dt><span class="strong">testLog</span></dt><dd>Provides the name of the test log file.</dd>
 * </d>
 */
public interface LogADT {
    // The '\' character.
    String SEPARATOR = System.getProperty("file.separator");

    // The path to the 'resources/logs' directory.
    String USR_PATH = System.getProperty("user.dir");
    String LOG_PATH = USR_PATH + SEPARATOR + ("src/main/resources/logs/").replace("/", SEPARATOR);

    // The file extension for all log files.
    String EXT = ".txt";  // extension for text files

    // The names of all log files (with special directories included) that should be generated.
    String testLog = "test_log";

    /**
     * This method returns the path to the logs directory.
     *
     * @return logs directory path
     */
    String getPath();

    /**
     * This method returns the extension for any given log file.
     *
     * @return extension for any log file
     */
    String getExtension();

    /**
     * This method returns the name for the test log file.
     *
     * @return test log file name
     */
    String getTestLog();
}
