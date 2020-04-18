package com.bluewhale.Importutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DbWriter {

	static void writeToDb(List<String[]> allData) {

		try {
			Connection conn = DbUtil.getDbConnection();

			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO BUS_SCHEDULE VALUES(?,?,?,?,?,?,?,?)");

			allData.remove(0);

			Set<String[]> dataSet = new HashSet<String[]>(allData);

			for (String[] row : dataSet) {

				pstmt.setString(1, row[0].trim());
				pstmt.setString(2, row[1].trim());
				pstmt.setString(3, row[2].trim());
				pstmt.setString(4, row[3].trim());
				pstmt.setInt(5, Integer.parseInt(row[4]));
				pstmt.setInt(6, Integer.parseInt(row[5]));
				pstmt.setString(7, row[6].trim());
				pstmt.setString(8, row[7].trim());

				int result = pstmt.executeUpdate();

				if (result == 1) {
					System.out.println("Records Inserted Successfully");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}