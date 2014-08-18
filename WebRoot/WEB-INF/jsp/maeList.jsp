<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/meta.jsp" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>Data List</title> 	
  </head>
  
  <body>
   <br>
	<div style="margin:20px 0;"></div>
	<div style="padding:5px 0;">
	    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="location='${ctx}/page'"></a>&nbsp;&nbsp;
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="location='${ctx}/mae/add'">添加</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="del()">删除</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="edit('${ctx}/mae/upd?id=')">修改</a>
	   <span> <input class="easyui-searchbox" data-options="prompt:'Please Input the start ID[id,id+5]:',searcher:doSearch" style="width:300px"></input> 
	   <label>默认查询【id，id+5】范围内的记录</label></span>
	</div>
	<table id="dataList" style="width:740px;height:340px"></table>
	
	
	<script type="text/javascript">
		$(function(){
			$('#dataList').datagrid({
				url:'${ctx}/mae/list',
				title:"DataList",
				fitcolumns:true,
				singleSelect:true,
				columns:[[
				         {field:'id',title:"Item ID",width:100},
				         {field:'featureType',title:"FeatureType",width:120},
				         {field:'columnName',title:"ColumnName",width:120},
				         {field:'condType',title:"CondType",width:120},
				         {field:'dataType',title:"DataType",width:120},
				         {field:'onlineDuration',title:"OnlineDuration",width:120}
				          ]],
				pagination:true,
				rownumbers:true
			});			
		});
		

		 function edit(url){
			var row = $('#dataList').datagrid('getSelected');
			if(!row){
				$.messager.alert("提示","请选择一条记录",'warning');return;
			}
		 	location = url+row.id;
		 }
		
		function del(){
			var row = $('#dataList').datagrid('getSelected');
			if(row){
				$.messager.confirm("提示", "Are you sure to delete?", function(r){
						if (r){
							$.post("${ctx}/mae/delete",{"id":row.id}, function(data) {
							  	$.messager.alert("提示", "操作成功",'info');
								$('#dataList').datagrid('reload');
							});
						}
					});
			}else{
				$.messager.alert("提示","请选择一条记录",'warning');
			}
		}
		
	    function doSearch(value){
			if(isNaN(value)) {
				$.messager.alert("提示","数据不合法，请输入正确的id",'warning');
				return;
			}
			if(value===""){
				$.messager.alert("提示","请输入id",'warning');
				return;
			} 
			
			alert('You input: ' + value);			 
			
		    $('#dataList').datagrid({
				url:'${ctx}/mae/search/'+value
			}); 
		}
	</script>
  </body>
</html>
