<%@ page pageEncoding="utf-8" %>
<html>
	<head>
		<title>试验</title>
		<script type="text/javascript">
			function showProjects() {
				
			}
		</script>
	</head>
	<body>
		<div>
			<form action="generateTestReportTemplate" method="POST">
				<br>
				<table>
					<tr>
						<td>模板名称</td>
						<td><input type="text" name="templatename" size="20" placeholder="例如：利民道-220kV避雷器-电气-交接试验-20160126" style="height: 30px; width: 350px; "></td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td>设备名称</td>
						<td>
							<select name="equipment" style="height:30px">
								<option value="10kV干式变">10kV干式变</option>
								<option value="35kV干式变" selected>35kV干式变</option>
								<option value="35kV油变">35kV油变</option>
								<option value="66kV站用变">66kV站用变</option>
								<option value="110kV二绕组">110kV二绕组</option>
								<option value="110kV三绕组">110kV三绕组</option>
								<option value="220kV二绕组">220kV二绕组</option>
								<option value="220kV三绕组">220kV三绕组</option>
							</select>
						</td>
					</tr>
					<tr>
						<td></td>
					</tr>
					<tr>
						<td>试验项目:</td>
						<td>
							<input type="checkbox" name="project" value="绝缘电阻(MΩ)">绝缘电阻(MΩ)
							<input type="checkbox" name="project" value="直流电阻">直流电阻
							<input type="checkbox" name="project" value="电压比">电压比
							<input type="checkbox" name="project" value="交流耐压">交流耐压
							<input type="checkbox" name="project" value="短路阻抗">短路阻抗
							<input type="checkbox" name="project" value="负载损耗">负载损耗
						</td>
					</tr>
				</table>
				<br>
				<input type="submit" value="生成模板">
			</form>
		</div>
	</body>
</html>