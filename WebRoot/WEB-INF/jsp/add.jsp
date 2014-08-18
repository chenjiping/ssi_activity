<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/meta.jsp" %>

<!DOCTYPE html>
<html>
  <head>
	<title>Add Data Page</title>
	<script>
	
		function submitForm(){
			$('#ff').form('submit',{    
			    url:'${ctx }/mae/insert.do',    
			    
				onSubmit : function() {
					// do some check 
					$('#cond').validatebox({
						required : true,
						validType : 'int'
					});
					$('#online').validatebox({
						required : true,
						validType : 'int'
					});
					// return false to prevent submit;    
				},
				success : function(data) {
					alert(data);
				}
			});

			//$('#ff').form('submit');      //数据可以进行不为空验证，但页面不能跳转
			//$('#ff').submit();              //页面可以跳转，但不能进行数据不为空验证
		}

		function clearForm() {
			$('#ff').form('clear');
		}
	</script>
</head>
  
  <body>
     <div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="insert new Data" style="width:400px">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff"  method="post">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>FeatureType:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" name="featureType" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>ColumnName:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" name="columnName" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>CondType:</td>
	    			<td><input id="cond" class="easyui-validatebox textbox" type="text" name="condType" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>DataType:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" name="dataType" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>OnlineDuration:</td>
	    			<td><input id="online" class="easyui-validatebox textbox" type="text" name="onlineDuration" data-options="required:true"></input></td>
	    		</tr>
	    	</table>
	    	
	    </form>
	    <div style="text-align:center;padding:5px">
	        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-back'" onclick="location='${ctx}/page'">Back</a>
	    	&nbsp;&nbsp;&nbsp;&nbsp;
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">Submit</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
	    </div>
   </div>
	</div>


  </body>
</html>
