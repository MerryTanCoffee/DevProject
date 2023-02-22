<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register All Form</title>
</head>
<body>
	<h1>Register All Form</h1><hr/>
	<form action = "/registerUser" method = "post">
		<table boarder = "1">
			<tr>
				<th>UserID</th>
				<td>
					<input type="text" name = "userId"/>
				</td>
			</tr>
			<tr>
				<th>Password</th>
				<td>
					<input type="password" name = "password"/>
				</td>
			</tr>
			<tr>
				<th>Name</th>
				<td>
					<input type="text" name = "userName"/>
				</td>
			</tr>
			<tr>
				<th>E-Mail</th>
				<td>
					<input type="text" name = "email"/>
				</td>
			</tr>
			<tr>
				<th>Birth</th>
				<td>
					<input type="text" name = "dateOfBirth"/>
				</td>
			</tr>
			<tr>
				<th>Gender</th>
				<td>
					<input type="radio" name = "gender" value="male"/>Male&nbsp;
					<input type="radio" name = "gender" value="female" checked="checked"/>Female&nbsp;
					<input type="radio" name = "gender" value="other" "/>Other&nbsp;
				</td>
			</tr>
			<tr>
				<th>Developer</th>
				<td>
					<input type="checkbox" name = "developer"  value ="Y"/>
				</td>
			</tr>
			<tr>
				<th>Foreigner</th>
				<td>
					<input type="text" name = "foreigner" value = "여"/>
				</td>
			</tr>
			<tr>
				<th>Nationality</th>
				<td>
					<select name = "nationality">
						<option value = "korea">korea</option> 
						<option value = "germany">germany</option> 
						<option value = "austrailia">austrailia</option> 
						<option value = "canada">canada</option> 
					
					</select>
				</td>
			</tr>
			<tr>
				<th>Car</th>
				<td>
					<select name = "cars"  multiple = "multiple">
						<option value = "volvo">volvo</option> 
						<option value = "jeep">jeep</option> 
						<option value = "bmw">bmw</option> 
						<option value = "audi">audi</option> 

					</select>
				</td>
			</tr>
			<tr>
				<th>Hobby</th>
				<td>
					<input type="checkbox" name = "hobby" value = "sports"/>sports<br/>
					<input type="checkbox" name = "hobby" value = "music"/>music<br/>
					<input type="checkbox" name = "hobby" value = "movie"/>movie<br/>
				</td>
			</tr>
			<tr>
				<th>PostCode</th>
				<td>
					<input type="text" name = "address.postCode"/>
				</td>
			</tr>
			<tr>
				<th>Address</th>
				<td>
					<input type="text" name = "address.location"/>
				</td>
			</tr>
			<tr>
				<th>Introduce</th>
				<td>
					<textarea name = "introduction" rows="10" cols="50"></textarea>
				</td>
			</tr>
			<tr>
			<td>
				<input type ="submit" name = "btnSubmit" value="등록"/>
				<input type ="reset" name = "btnReset" value="취소"/>
			</td>
			</tr>
		</table>
	</form>
</body>
</html>