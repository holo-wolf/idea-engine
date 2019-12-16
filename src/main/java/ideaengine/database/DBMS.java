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
package ideaengine.database;

import java.io.IOException;

/**
 * The Database Management Systems (DBMS) class handles the connection to the Idea Network along with all other
 * embedded-SQL capabilities. You can extend the appropriate database management system as per your operating system.
 *
 * <dl>
 *     <dt><span class="strong">DBMS()</span></dt><dd>Constructor that initializes the database management system.</dd>
 * </dl>
 */
public class DBMS extends PostgreSQL {
    /**
     * The DBMS constructor initializes the database management system to determine if connecting to any given database
     * is achievable.
     *
     * @param check boolean parameter to determine if database should ensure connectivity
     * @throws IOException logging system is not properly configured
     */
    public DBMS(boolean check) throws IOException {
        if (check) {
            initialization();
        }
    }
}
