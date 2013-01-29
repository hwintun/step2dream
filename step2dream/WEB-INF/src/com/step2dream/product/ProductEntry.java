package com.step2dream.product;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.*;

public class ProductEntry extends ActionSupport {

	private Product p;
	private List<String> colorList;
	private List<File> fileUpload = new ArrayList<File>();
	private List<String> fileUploadContentType = new ArrayList<String>();
	private List<String> fileUploadFileName = new ArrayList<String>();


	public ProductEntry() {
		colorList = new ArrayList();
		colorList.add("White");
		colorList.add("Black");
		colorList.add("Brown");
		colorList.add("Red");
		colorList.add("Green");
	}

	public List<File> getFileUpload() {
		return fileUpload;
	}



	public void setFileUpload(List<File> fileUpload) {
		this.fileUpload = fileUpload;
	}



	public List<String> getFileUploadContentType() {
		return fileUploadContentType;
	}



	public void setFileUploadContentType(List<String> fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}


	public List<String> getFileUploadFileName() {
		return fileUploadFileName;
	}



	public void setFileUploadFileName(List<String> fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}



	public List<String> getColorList() {
		return colorList;
	}

	public void setColorList(List<String> colorList) {
		this.colorList = colorList;
	}

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

	public String create() throws Exception {
		return SUCCESS;
	}

	public String save() throws Exception {

		if (saveData()) {
			return SUCCESS;
		} else
			return INPUT;
	}

	private boolean saveData() throws Exception {
		boolean flag = true;
		String destPath = this.getText("dir.destPath");
		System.out.println(destPath);
		List<String> fileName = new ArrayList<String>();
		try {
			for(int i=0;i<fileUpload.size();i++) {
				File destFile = new File(destPath, fileUploadFileName.get(i));
				FileUtils.copyFile(fileUpload.get(i), destFile);
				fileName.add(fileUploadFileName.get(i));
			}
			
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/step2dream";
			Connection connection = DriverManager.getConnection(url, "root",
					"root");
			String sql = "INSERT INTO product (productCode,productCategory,productBrand,productPrize,productQty,productColor,productSize," +
					"image1,image2,image3,image4) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, p.getProductCode());
			pstmt.setString(2, p.getProductCategory());
			pstmt.setString(3, p.getProductBrand());
			pstmt.setDouble(4, p.getProductPrize());
			pstmt.setInt(5, p.getProductQty());
			pstmt.setString(6, p.getProductColor());
			pstmt.setInt(7, p.getProductSize());
			pstmt.setString(8, fileName.get(0));
			pstmt.setString(9, fileName.get(1));
			pstmt.setString(10, fileName.get(2));
			pstmt.setString(11, fileName.get(3));
			pstmt.executeUpdate();
			connection.close();
		} catch (ClassNotFoundException e) {
			flag = false;
			System.err.println("Error loading driver: " + e);
		} catch (SQLException er) {
			System.err.println("Error connecting: " + er);
			this.addActionError(er.getMessage());
			flag = false;
		}
		return flag;
	}
}
