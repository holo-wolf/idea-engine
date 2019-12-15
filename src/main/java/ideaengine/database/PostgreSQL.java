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

import java.sql.*;

/**
 * The PostgreSQL abstract class implements the DatabaseADT interface. This class loosely provides a working skeleton
 * of how one should connect Java to PostgreSQL (version 12.1 or later) in order to achieve embedded SQL functionality.
 *
 * <dl>
 *     <dt><span class="strong">void initialization()</span></dt><dd>Checks if PostgreSQL credentials are valid.</dd>
 *     <dt><span class="strong">String getJDBC()</span></dt><dd>Returns the JDBC pathway from the interface class.</dd>
 *     <dt><span class="strong">String getRole()</span></dt><dd>Returns the ROLE from the interface class.</dd>
 *     <dt><span class="strong">String getPass()</span></dt><dd>Returns the PASS from the interface class.</dd>
 * </dl>
 */
abstract class PostgreSQL implements DatabaseADT {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rSet = null;

    /**
     * This method will perform a quick initialization to determine if connecting to a PostgreSQL database is
     * achievable.
     */
    public void initialization() {
        try {
            // Open the connection via the JDBC pathway (e.g. jdbc:postgresql://host:port/database).
            conn = DriverManager.getConnection(getJDBC(), getRole(), getPass());

            // Create statement.
            stmt = conn.createStatement();

            // Execute statement.
            rSet = stmt.executeQuery("SELECT version()");

            // Output the result if everything was successful.
            if (rSet.next())
                System.out.println(rSet.getString(1));
        }  catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // Ensure that statements cannot be created.
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }

                // Ensure that statements cannot be executed.
                if (rSet != null) {
                    rSet.close();
                    rSet = null;
                }

                // Ensure that the connection is closed.
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method returns the Java Database Connectivity pathway.
     *
     * @return JDBC pathway
     */
    public String getJDBC() {
        return JDBC;
    }

    /**
     * This method returns the name of role which has the appropriate permissions and privileges in regards to the
     * database being accessed.
     *
     * @return name of role
     */
    public String getRole() {
        return ROLE;
    }

    /**
     * This method returns the password of the role which has the appropriate permissions and privileges in regards to
     * the database being accessed.
     *
     * @return password of role
     */
    public String getPass() {
        return PASS;
    }
}
