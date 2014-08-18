<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/meta.jsp" %>
<!DOCTYPE HTML>
<html>
  <head>
	<title>Add Data Page</title>
	<style scoped="scoped">
		.textbox{
			height:20px;
			margin:0;
			padding:0 2px;
			box-sizing:content-box;
		}
	</style>

  </head>
  
  <body>
    <div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="Update Data" style="width:400px">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff" action="${ctx }/mae/update.do" method="post">
	    	<input type="hidden" name="id" value="${Aaa.id }"/>
	    	<table cellpadding="5">
	    		<tr>
	    			<td>FeatureType:</td>
	    			<td><input class="easyui-textbox" type="text" name="featureType" value="${ Aaa.featureType}"></input></td>
	    		</tr>
	    		<tr>
	    			<td>ColumnName:</td>
	    			<td><input class="easyui-textbox" type="text" name="columnName" value="${Aaa.columnName }"></input></td>
	    		</tr>
	    		<tr>
	    			<td>CondType:</td>
	    			<td><input class="easyui-textbox" type="text" name="condType" value="${Aaa.condType }"></input></td>
	    		</tr>
	    		<tr>
	    			<td>DataType:</td>
	    			<td><input class="easyui-textbox" type="text" name="dataType" value="${Aaa.dataType }"></input></td>
	    		</tr>
	    		<tr>
	    			<td>OnlineDuration:</td>
	    			<td><input class="easyui-textbox" type="text" name="onlineDuration" value="${Aaa.onlineDuration }"></input></td>
	    		</tr>
	    		<tr>
	    			<td><a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-back'" onclick="location='${ctx}/page'">Back</a>
	    	        </td>
	    	        <td>
	    			<button type="submit" >Submit</button>&nbsp;
	    			<button type="reset" >Reset</button>
	    			</td> 
	    		</tr>
	    	</table>
	    </form>

	    </div>
	</div>
  </body>
</html>
	    			