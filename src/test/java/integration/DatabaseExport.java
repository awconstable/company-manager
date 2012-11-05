package integration;


public class DatabaseExport {

	public static void main(String[] args) throws Exception {
		// database connection

		/*		Class.forName("com.mysql.jdbc.Driver");
		Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://192.168.0.20:3306/CROSSFIRE_company", "root", "");
		IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);

		DatabaseConfig config = connection.getConfig();
		config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
		config.setProperty(DatabaseConfig.PROPERTY_METADATA_HANDLER, new MySqlMetadataHandler());

		// partial database export
		QueryDataSet partialDataSet = new QueryDataSet(connection);
		partialDataSet.addTable("options", "select options.key, options.value from options");
		FlatXmlDataSet.write(partialDataSet,
				new FileOutputStream("options.xml"));*/

		// full database export
		/*		IDataSet fullDataSet = connection.createDataSet();
		FlatXmlDataSet.write(fullDataSet, new FileOutputStream("full.xml"));*/

		// dependent tables database export: export table X and all tables that
		// have a PK which is a FK on X, in the right order for insertion
		/*		String[] depTableNames = TablesDependencyHelper.getAllDependentTables(
				connection, "X");
		IDataSet depDataset = connection.createDataSet(depTableNames);
		FlatXmlDataSet
		.write(depDataSet, new FileOutputStream("dependents.xml"));*/

	}
}
