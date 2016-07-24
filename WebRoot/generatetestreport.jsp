<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.*,songbiandian.middleware.*" %>
<html>
	<head>
		<title>试验报告模板</title>
		<style type="text/css">
			p.title{
				text-align:center;
				font-size:25;
			}
			table.main{
				text-align:center;
				width:50%;
				margin:auto;
				border-collapse:collapse;
				border-spacing:0px;
				border:none;
			}
			td{
				border:solid #000 1px;
				height:40px;
			}
			table.sub{
				text-align:center;
				width:100%;
				border-collapse:collapse;
				border:none;
			}
			td.sub{
				width:80px;
				border:solid #000 1px;
				height:40px;
			}
			td.instrument{
				color:green;
				border:solid #000 1px;
				height:40px;
			}
			td.standard{
				color:red;
				border:solid #000 1px;
				height:40px;
			}
		</style>
	</head>
	<body>
		<p class="title"><%=session.getAttribute("templatename") %>试验报告模板</p>
		<div class="reporttemplate">
			<form action="saveTestReport" method="POST">
			<table class="main" cellpadding="0px">
				<tr></tr>
				<%
					String equipmentName = (String)session.getAttribute("equipmentname");
					String[] projects = (String[])session.getAttribute("projectstring");
					HashMap<String, ArrayList<String>> positionListMap = (HashMap<String, ArrayList<String>>)session.getAttribute("positionofprojectmap");
					HashMap<String, ArrayList<String>> paramListMap = (HashMap<String, ArrayList<String>>)session.getAttribute("paramofpositionmap");
					HashMap<String, String> standardMap = (HashMap<String, String>)session.getAttribute("standardMap");
					HashMap<String, String> testInstrumentMap = (HashMap<String, String>)session.getAttribute("testinstrumentMap");
					HashMap<String, ArrayList<String>> paramOfFirstLineMap = (HashMap<String, ArrayList<String>>)session.getAttribute("paramoffirstlinemap");
					HashMap<String, HashMap<String, ArrayList<String>>> paramOfProjectMap = (HashMap<String, HashMap<String, ArrayList<String>>>)session.getAttribute("paramofprojectmap");
					HashMap<String, ArrayList<String>> paramOfNoPositionMap = (HashMap<String, ArrayList<String>>)session.getAttribute("paramofnoposition");
					for (int i = 0 ; i < projects.length ; i++) {
						HashMap<String, ArrayList<String>> paramOfSingleProjectMap = paramOfProjectMap.get(projects[i]);
				 %>
				 		<tr>
				 			<td><%=projects[i] %></td>
				 			<td>
				 				<table class="sub">
				 					<%
				 						ArrayList<String> positionListOfProject = positionListMap.get(projects[i]);
				 						if (positionListOfProject == null) {
				 							ArrayList<String> paramOfNoPosition = paramOfNoPositionMap.get(projects[i]);
				 							if (paramOfNoPosition.size() == 1) {
				 								String tdName = equipmentName + "_" + projects[i] + "_" + paramOfNoPosition.get(0);
				 					 %>
				 					 			<tr>
				 					 				<td class="sub"><input type="text" name=<%=tdName %>></td>
				 					 			</tr>
				 					 <%
				 					 		}
				 					 		else {
				 					  %>
				 					  			<tr>
				 					 <%
				 					  			for (String param : paramOfNoPosition) {
				 					  				String tdName = equipmentName + "_" + projects[i] + "_" + param;
				 					  %>
				 					   				<td class="sub">
				 					   					<%=param %>
				 					   				</td>
				 					   				<td class="sub"><input type="text" name=<%=tdName %>></td>
				 					 <%
				 					  			}
				 					  %>
				 					  			</tr>
				 					 <%
				 					  			}
				 					  		}
				 					  	else {
				 					  %>
				 					   			<tr>
				 					   				<td>试验位置</td>
				 					 <%
				 					   			ArrayList<String> paramOfFirstLineList = paramOfFirstLineMap.get(projects[i]);
				 					   			session.setAttribute("paramnum", paramOfFirstLineList.size());
				 					   			if (paramOfFirstLineList.size() == 1) {
				 					  %>
				 					   				 <td class="sub">试验值</td>
				 					 <%
				 					   			}
				 					   			else {
				 					   				for (String param : paramOfFirstLineList) {
				 					  %>
				 					   				 	<td class="sub"><%=param %></td>
				 					 <%
				 					   				}
				 					   			}
				 					  %>
				 					   			</tr>
				 					 <%
				 					   		for (String position : positionListOfProject) {		
				 				      %>
				 					   			<tr>
				 					   				<td style="width:120px"><%=position %></td>
				 					   				<%
				 					   				HashMap<String, ArrayList<String>> paramOfThisPositionMap = paramOfProjectMap.get(projects[i]);
				 					   				ArrayList<String> paramOfThisPositionList = paramOfThisPositionMap.get(position);
				 					   				if (paramOfThisPositionList.size() == paramOfFirstLineList.size()) {
				 					   					for (int j = 0 ; j < paramOfThisPositionList.size() ; j++) {
				 					   						String tdName = equipmentName + "_" + projects[i] + "_" + position + "_" + paramOfThisPositionList.get(j);
				 					   				 %>
				 					   				 		<td class="sub"><input type="text" name=<%=tdName %>></td>
				 					   				<%
				 					   					}
				 					   				}
				 					   				else {
				 					   					if (paramOfThisPositionList.size() == 1) {
				 					   						String tdName = equipmentName + "_" + projects[i] + "_" + position + "_" + paramOfThisPositionList.get(0);
				 					   				 %>
				 					   				 		<td id="singleparam">
				 					   				 			<input type="text" name=<%=tdName %>>
				 					   				 		</td>
				 					   				<%
				 					   					}
				 					   					else {
				 					   						for (String parameter : paramOfThisPositionList) {
				 					   							String tdName = equipmentName + "_" + projects[i] + "_" + position + "_" + parameter;
				 					   				 %>
				 					   				 			<td><%=parameter %></td>
				 					   				 			<td><input type="text" name=<%=tdName %>></td>
				 					   				<%
				 					   						}
				 					   					}
				 					   				}
				 					   				 %>
				 					   			</tr>
				 					 <%
				 					 		}
				 					 	}
				 					  %>
				 				</table>
				 			</td>
				 		</tr>
				 		<tr>
				 			<td>试验标准</td>
				 			<td class="standard"><%=standardMap.get(projects[i]) %></td>
				 		</tr>
				 		<tr>
				 			<td>试验仪器</td>
				 			<td class="instrument"><%=testInstrumentMap.get(projects[i]) %></td>
				 		</tr>
				 		<tr>
				 			<td>项目结论</td>
				 			<td>
				 				<select name="issuccessofsingletest" style="height:30px">
				 					<option value="是">合格</option>
				 					<option value="否">不合格</option>
				 				</select>
				 			</td>
				 		</tr>
				 <%
				 	}
				  %>
				 <tr>
				 	<td>试验报告是否合格</td>
				 	<td>
				 		<select name="issuccessofthereport" style="height:30px">
				 			<option value="是" selected>合格</option>
				 			<option value="否">不合格</option>
				 		</select>
				 	</td>
				 </tr>
			</table>
			<br>
			<div style="text-align:center"><input type="submit" value="提交"></div>
			</form>
		</div>
	</body>
</html>