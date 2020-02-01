package capstoneproject2017;
import java.sql.*;
import javax.swing.table.AbstractTableModel;

public class ResultSetTableModel extends AbstractTableModel{
    private Connection connect;
    private Statement statement;
    private ResultSet rs;
    private ResultSetMetaData rsmd;
    private int numRows;
    private Boolean dbConnected = false;
    
    public ResultSetTableModel (String url, String username, String password, String query) throws SQLException {
        connect = DriverManager.getConnection(url, username, password);
        statement = connect.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
        dbConnected = true;
        
        setQuery (query);
    }   //End Constructor
    
    public Class getColumnClass (int column) throws IllegalStateException {
    
        if (!dbConnected)
            throw new IllegalStateException ("Not connected to the Inventory database");
        
        try{
            String className = rsmd.getColumnClassName(column + 1);
            return Class.forName(className);
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        return Object.class;
}   //End Class getColumnClass
    
    public int getColumnCount() throws IllegalStateException {
        
        if (!dbConnected)
           throw new IllegalStateException ("Not connected to the Inventory database");
        
        try{
            return rsmd.getColumnCount();
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return 0;
    }   //End Class getColumnCount
    
    public String getColumnName (int column) throws IllegalStateException {
        
        if (!dbConnected)
           throw new IllegalStateException ("Not connected to the Inventory database");
        
        try{
            return rsmd.getColumnName(column + 1);
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return "";
    }   //End Class getColumnName
    
    public int getRowCount() throws IllegalStateException{

        if (!dbConnected)
           throw new IllegalStateException ("Not connected to the Inventory database");
        
        return numRows;
    }
    
    public Object getValueAt(int row, int column) throws IllegalStateException {

        if (!dbConnected)
           throw new IllegalStateException ("Not connected to the Inventory database");
        
        try{
            rs.absolute(row + 1);
            return rs.getObject(column + 1);
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return "";
    }   //End Method getValueAt
    
    public void setQuery (String query) throws SQLException, IllegalStateException {

        if (!dbConnected)
           throw new IllegalStateException ("Not connected to the Inventory database");
        
        rs = statement.executeQuery(query);
        rsmd = rs.getMetaData();
        rs.last();
        numRows = rs.getRow();
        fireTableStructureChanged();
    }   //End Method setQuery
    
    public void disconnectFromDatabase(){
        if (dbConnected){
            try{
                rs.close();
                statement.close();
                connect.close();
            }   //End Try
            catch (SQLException sqlException){
                sqlException.printStackTrace();
            }   //End Catch
            finally{
                dbConnected = false;
            }   //End Finally
        }   //End If
    }   //End Method disconnectFromDatabase
    
}   //End ResultTableModel Class

