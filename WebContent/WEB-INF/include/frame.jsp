<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
	<head>
		<title>Page Finder</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/style.css"/>
	</head>


		<frameset rows="30%, 70%">
			<frame name="fixed" src="${pageContext.request.contextPath}/controller"></frame>
			<frame name="dynamic" src="${pageContext.request.contextPath}/index"></frame>
		</frameset>
	
</html>