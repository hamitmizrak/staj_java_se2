package com.hamit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.hamit.dto.RegisterDto;

public class RegisterDao implements IDaoImplements<RegisterDto> {
	ResultSet resultSet;
	private RegisterDto registerDto;

	@Override
	public void create(RegisterDto registerDto) {
		try (Connection connection = dbConnection()) {// try with resouces

			java.sql.PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into register(register_name,register_surname,register_email,register_password,roles) values(?,?,?,?,?)");
			preparedStatement.setString(1, registerDto.getRegisterName());
			preparedStatement.setString(2, registerDto.getRegisterSurname());
			preparedStatement.setString(3, registerDto.getRegisterEmail());
			preparedStatement.setString(4, registerDto.getRegisterPassword());
			preparedStatement.setString(5, registerDto.getRegisterRoles());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Ekleme sırasında hata meydana geldi");
			e.printStackTrace();
		}
	}

	@Override
	public void update(RegisterDto registerDto) {
		try (Connection connection = dbConnection()) {// try with resouces
			PreparedStatement preparedStatement = connection.prepareStatement(
					// update admin2 set user_email=?,user_password=? where id="+registerDto.getId();
					"update  register set register_name=?,register_surname=?,register_email=?,register_password=?,roles=? where register_id=? ");
			preparedStatement.setString(1, registerDto.getRegisterName());
			preparedStatement.setString(2, registerDto.getRegisterSurname());
			preparedStatement.setString(3, registerDto.getRegisterEmail());
			preparedStatement.setString(4, registerDto.getRegisterPassword());
			preparedStatement.setString(5, registerDto.getRegisterRoles());
			preparedStatement.setInt(6, registerDto.getRegisterId());
			int rows = preparedStatement.executeUpdate();
			if (rows < 0) {
				System.out.println("güncelleme başarısız");
			} else {
				System.out.println("Güncelleme başarılı");
			}
		} catch (Exception e) {
			System.out.println("güncelleme sırasında hata meydana geldi");
			e.printStackTrace();
		}
	}

	@Override
	public void delete(long id) {
		try (Connection connection = dbConnection()) {// try with resouces
			java.sql.PreparedStatement preparedStatement = connection
					.prepareStatement("delete from  register where register_id=?");
			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Ekleme sırasında hata meydana geldi");
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<RegisterDto> list() {
		ArrayList<RegisterDto> list = new ArrayList<RegisterDto>();
		RegisterDto registerDto;
		try (Connection connection = dbConnection()) {
			java.sql.PreparedStatement preparedStatement = connection.prepareStatement("select * from register");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				registerDto = new RegisterDto();
				registerDto.setRegisterId(resultSet.getInt("register_id"));
				registerDto.setRegisterName(resultSet.getString("register_name"));
				registerDto.setRegisterPassword(resultSet.getString("register_password"));
				registerDto.setRegisterSurname(resultSet.getString("register_surname"));
				registerDto.setRegisterEmail(resultSet.getString("register_email"));
				registerDto.setRegisterRoles(resultSet.getString("roles"));
				registerDto.setDate(resultSet.getDate("creation_date"));
				list.add(registerDto);
			}
		} catch (Exception e) {
			System.out.println("Listeleme sırasında hata oldu");
			e.printStackTrace();
		}
		return list;
	}

	// Login için sorgulama
	// select * from register where register_email="mizrak@gmail.com" and roles="admin";
	// public ArrayList<RegisterDto> searchInformation() {
	// RegisterDto registerDto = new RegisterDto();
	// String sql = "select * from admin2 where user_email=? and user_password=?";
	// try (Connection connection = dbConnection()) {
	// PreparedStatement preparedStatement = connection.prepareStatement(sql);
	// preparedStatement.setString(1, registerDto.getUserEmail());
	// preparedStatement.setString(2, adminDto.getUserPassword());
	// this.resultSet = preparedStatement.executeQuery();
	// System.out.println("Search listelendi.");
	// if (resultSet.next()) {
	// adminDto = new AdminDto();
	// adminDto.setUserEmail(resultSet.getString("user_email"));
	// adminDto.setUserPassword(resultSet.getString("user_password"));
	// return ArrayList<AdminDto>;
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return (ArrayList<AdminDto>) adminDto;
	// }

}
