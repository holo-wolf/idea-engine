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

/**
 * The DatabaseADT interface provides an abstraction of the different types of variables and methods one may use to
 * connect a database. Utilizing environment variables for sensitive information is strongly recommended.
 *
 * <dl>
 *     <dt><span class="strong">JDBC</span></dt><dd>Java Database Connectivity pathway (e.g. jdbc:postgresql://).</dd>
 *     <dt><span class="strong">ROLE</span></dt><dd>Name of role with the appropriate permissions and privileges.</dd>
 *     <dt><span class="strong">PASS</span></dt><dd>Password of role in order to form a connection with database.</dd>
 * </dl>
 */
interface DatabaseADT {
    // Refer to the DatabaseADT JavaDoc for a brief explanation regarding the variables below.
    String JDBC = System.getenv("PostgreSQL_IDEA_JDBC");
    String ROLE = System.getenv("PostgreSQL_IDEA_ROLE");
    String PASS = System.getenv("PostgreSQL_IDEA_LOGIN");

    /**
     * This method will perform a quick initialization to determine if connecting to any given database is achievable.
     */
    void initialization();

    /**
     * This method returns the Java Database Connectivity pathway.
     *
     * @return JDBC pathway
     */
    String getJDBC();

    /**
     * This method returns the name of role which has the appropriate permissions and privileges in regards to the
     * database being accessed.
     *
     * @return name of role
     */
    String getRole();

    /**
     * This method returns the password of the role which has the appropriate permissions and privileges in regards to
     * the database being accessed.
     *
     * @return password of role
     */
    String getPass();
}
