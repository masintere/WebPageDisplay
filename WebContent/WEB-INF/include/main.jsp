<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd"> 
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/style.css"/>
	</head>
	<body>
	<div class="page">
		<div class="header">	
			<form target="dynamic">
				
				URL: 
				<input type="text" name="url">
			
				<input type="radio" name="format" value="html">HTML   
				<input type="radio" name="format" value="source">Source		
				
				<select name = "Display">
	              <option value="desktop">desktop</option>
	              <option value="tablet">tablet</option>
	              <option value="mobile">mobile</option>
	            </select>
	            
	            <input type="submit" value="Submit">
			</form>
			
			<p>Number of times site was used = ${count}</p>
			<p></p>
			
		</div>
	</div>
	</body>
</html>