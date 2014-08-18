<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="/common/meta.jsp"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Login</title>
<script type="text/javascript" src="${ctx }/js/MyChartJs.js"></script>
<script type="text/javascript" src="${ctx }/js/MyJqClock.js"></script>
</head>

<body>
	<table class="table table-bordered">
		<tr>
			<td>
				<div class="col-md-12">
					<button type="button" class="btn btn-info" onclick="doXData()">固定x轴数据</button>
					<button type="button" class="btn btn-info" onclick="doChartData()">Multiple
						Data</button>
					<button type="button" class="btn btn-info" onclick="doChartData1()">条形2种数据</button>
					<button type="button" class="btn btn-info" onclick="doAxisChart()">绘制折线图</button>
					<button type="button" class="btn btn-info"
						onclick="doMarginsChart()">绘制Axis Margins</button>
					<div style="height:25px"></div>
					<div class="col-sm-2">
						<div id="jqChart" style="width: 500px; height: 300px;"></div>
						<div style="height:25px"></div>
						<button id="button1" type="button" class="btn btn-success"
							style="display: none">Export to Image</button>
					</div>
				</div>
			</td>
			<td>
				<div class="col-md-8">
					<button type="button" class="btn btn-info" onclick="doPieChart()">绘制饼状图</button>
					<div style="height:25px"></div>
					<div id="jqChart1" style="width: 500px; height: 300px;"></div>
					<div style="height:25px"></div>
					<button id="button2" type="button" class="btn btn-success"
						style="display: none">Export to Pdf</button>
				</div>
			</td>
			<td>
				<div class="col-md-8">
					<button type="button" class="btn btn-info" onclick="doClock()">绘制图表仪</button>
					<div style="height:25px"></div>
					<div style="width: 500px; height: 300px;">
						<div id="jqRadialGauge" style="width: 280px; height: 280px;"></div>
					</div>
				</div>
			</td>
		</tr>
	</table>


</body>
</html>