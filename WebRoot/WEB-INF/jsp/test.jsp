<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/common/meta.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>test</title>
</head>

<body>
	<table id="dg"></table>
	<script type="text/javascript">
		$('#dg').datagrid({
			url : '${ctx}/getData',
			columns : [ [ {
				field : 'id',
				title : 'id',
				width : 100
			}, {
				field : 'columnName',
				title : 'columnName',
				width : 100
			}] ],
			pagination:true
		});
	</script>
</body>
</html>
