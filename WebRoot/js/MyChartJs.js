
$(function(){
	doXData();
	doPieChart();
	//doClock();
});

 var background = {
                 type: 'linearGradient',
                 x0: 0,
                 y0: 0,
                 x1: 0,
                 y1: 1,
                 colorStops: [{ offset: 0, color: '#d2e6c9' },
                              { offset: 1, color: 'white' }]
             };
  	   
function doXData(){
	$('#jqChart').jqChart({
        title: { text: 'Category Axis' },
        background: background,
       /* tooltips: {
            type: 'shared'
        },*/
        animation: { duration: 1 },
        dataSource: {
            ajax: {
                type: "POST",
                url: "../../ssi_activity/mae/xchart",
                data: "",
                dataType: 'json'
            }
        },
        axes: [
            {
                type: 'category',
                location: 'bottom',
                //categories: ['Cat 1', 'Cat 2', 'Cat 3', 'Cat 4', 'Cat 5', 'Cat 6'],  //指定X轴数据，series中y轴数据动态绑定
                categories: ['A', 'B', 'C', 'D', 'E', 'F', 'G']

                /*type: 'linear',
                location: 'left',
                extendRangeToOrigin: true        //类型为linear的轴线，显示其原点 0 
                minimum: 10,
                maximum: 100,
                interval: 10       //间隔
                
                
                logarithmic: true,
                logBase: 10,
                minorGridLines: { interval: 2, strokeStyle: 'red' }
                */
                
                
//             类圆形显示数据
                /*{
                    type: 'linearRadius',
                    minimum: 0,
                    maximum: 100,
                    interval: 20,
                    innerExtent: 0,
                    renderStyle: 'polygon',
                    majorTickMarks: { visible: true }
                }*/

                
              /*location: 'left',
            	customTickMarks: [30, 40, 70, 80, 90]   //无类型，指定Y轴数据，则series中数据动态绑定
*/
            }
        ],
        series: [
            /*{
                type: 'column',                          //条形数据显示
                yValuesField: 'value'
                //data: [70, 40, 85, 50, 25, 40]
            }*/
            {
                type: 'line',
                title: 'Series 1',
                yValuesField: 'value1',
                //data: [62, 70, 68, 58, 52, 60, 48],
                strokeDashArray: [10, 10]
            },
            {
                type: 'line',
                title: 'Series 2',
                yValuesField: 'value2',
                //data: [56, 30, 62, 65, 40, 36, 70],
                strokeDashArray: [2, 2]
            }

        ]
    });	
	
   $('#button1').show().click(function () {
		
		var config = {
				fileName: 'Chart.png',
				type: 'image/png' // 'image/png' or 'image/jpeg'
		};
		
		$('#jqChart').jqChart('exportToImage', config);
	});
 
}
 
function doChartData(){		  
  	  $('#jqChart').jqChart({
            title: { 
            text: 'Binding to Remote Data' },
            border: { strokeStyle: '#6ba851' },
            background: background,
            animation: {
            	enabled: true,
                delayTime: 1,
                duration: 2 },      //完成加载时间
            shadows: {
                enabled: true
            },
            dataSource: {
                ajax: {
                    type: "POST",
                    url: "../../ssi_activity/mae/chart",
                    data: "",
                    dataType: 'json'
                }
            },
            /*axes: [
                   {
                       name: 'y1',
                       location: 'left',
                       plotBands: [
                                   {
                                       fillStyle: '#fcb441',
                                       from: 70,
                                       to: 60,
                                       zIndex: 0, // Posible values - 0, 1, 2
                                       title: 'Good'
                                   },
                                   {
                                       fillStyle: '#e0400a',
                                       from: 60,
                                       to: 90,
                                       zIndex: 0, // Posible values - 0, 1, 2
                                       title: 'Very Good'
                                   }
                               ]
                   		/*plotLines: [
                               {
                                   lineWidth: 2,
                                   strokeStyle: 'green',
                                   value: 42,
                                   zIndex: 0, // Posible values - 0, 1, 2
                                   title: {
                                       text: 'Target 1',
                                       hAlign: 'right',
                                       fillStyle: 'green'
                                   }
                               },
                               {
                                   lineWidth: 2,
                                   strokeStyle: 'red',
                                   value: 72,
                                   zIndex: 0, // Posible values - 0, 1, 2
                                   title: {
                                       text: 'Target 2',
                                       hAlign: 'right',
                                       fillStyle: 'red'
                                   }
                               }
                           ]
*/
                 /*  },
                   {
                       name: 'y2',
                       location: 'right',
                       strokeStyle: '#FCB441',
                       //在象限内以固定区间以不同颜色显示轴线
                       majorGridLines: {
                           strokeStyle: '#FCB441'
                       },
                       majorTickMarks: {
                           strokeStyle: '#FCB441'
                       }
                   }
                   
               ],*/
            series: [
                {
                	title: 'Column',  
                    type: 'column',     
                    axisY: 'y1',
                    xValuesField: 'date1',                 
                 //验证字段类型
                  /*    {
                        name: 'date',
                        type: 'dateTime' // string, numeric, dateTime
                    },  */
                    yValuesField: 'value1',
                    labels: {
                        font: '14px sans-serif',
                        fillStyle: 'red',
                        stringFormat: '%d K'
                    }
                },
                {
                	title: 'Line',                      //折线数据显示
                    type: 'line',
                    axisY: 'y2',
                    xValuesField: 'date2',
                    yValuesField: 'value2'
                }
            ]
        });

    }
  		
  function doChartData1(){	
	  $('#jqChart').jqChart({
          title: { text: 'Column Chart' },
          //legend: { visible: false },
          animation: { duration: 1 },
          shadows: {
              enabled: true
          },
          dataSource: {
              ajax: {
                  type: "POST",
                  url: "../../ssi_activity/mae/chart",
                  data: "",
                  dataType: 'json'
              }
          },
          axes: [					//轴线
               /*{
                     type: 'linear',
                     location: 'left',
                     crossing: 50         //中心轴在50
                     *********************************
                     labels: {
                            fillStyle: 'red',         //Y轴数据颜色
                            stringFormat: '%d %%',
                            font: '12px sans-serif'
                        }
                     *********************************
                     lineWidth: 4,
                     strokeStyle: 'red'
                     *********************************
                     location: 'bottom',
                     categories: ['Cat 1', 'Cat 2', 'Cat 3', 'Cat 4', 'Cat 5', 'Cat 6']       //可以使用  cat 1\nDog 1 这种写法
                     //在series中只需y轴的数据即可，使用类别指定x轴
                 }
*/
                 {
                     location: 'left',
                     majorGridLines: {
                         lineWidth: 2,
                         strokeStyle: 'red',
                         interval: 20
                     },
                     minorGridLines: {
                         lineWidth: 1,
                         strokeStyle: 'green',
                         strokeDashArray: [2, 2],
                         interval: 5
                     }
                 }
             ],
          series: [
              {
                  type: 'column',
                  title: 'Series 1',
                  fillStyle: '#418CF0',
                  xValuesField: 'date1',
                  yValuesField: 'value1'
              },
              {
                  type: 'column',     //or 'bar' , 'bubble' , 'scatter'    参看chartFeatures
                  /*'rangeBar' or 'range' or 'rangeColumn'     data: [['A', 33, 43], ['B', 57, 62], ['C', 13, 30],
                  ['D', 12, 40], ['E', 35, 70], ['F', 7, 30], ['G', 24, 30]]*/
                    

                  title: 'Series 2',
                  /*var fillStyle1 = {
                          type: 'radialGradient', or 'linearGradient',
                          x0: 0.35,
                          y0: 0.35,
                          r0: 0.0,
                          x1: 0.35,
                          y1: 0.35,
                          r1: 1,
                          colorStops: [{ offset: 0, color: 'white' },
                                       { offset: 1, color: '#418CF0' }]
                      };*/  
                  fillStyle: '#FCB441',       //可以使用变量定义的值,制作各种效果;可以使用集合，将每个字段颜色添加进去显示
                  xValuesField: 'date1',
                  yValuesField: 'value2'
                	  
                /*cursor: 'pointer',
                  hyperlinks: ['www.google.com', 'www.yahoo.com', 'www.bing.com']
                  //有其对应实现的方法
                */
              }
          ]
      });
	  
	 /* $('#jqChart').bind('dataPointMouseDown', function (event, data) {
          var link = data.series.hyperlinks[data.index];
          window.open('http://' + link);
      });
*/
  }
  
  function doAxisChart(){
	  $('#jqChart').jqChart({
          title: {
              text: 'Axis Titles'
          },
          animation: {
              duration: 1
          },
          dataSource: {
              ajax: {
                  type: "POST",
                  url: "../../ssi_activity/mae/chart1",
                  data: "",
                  dataType: 'json'
              }
          },
          axes: [
              {
                  type: 'linear',
                  location: 'bottom',
                  title: {
                      text: 'Axis Title X',
                      fillStyle: 'green'
                  },
                  extendRangeToOrigin: true        //类型为linear的轴线，显示原点 0 
                  //reversed: true                 //轴线数值倒叙排列
              },
              {
                  type: 'linear',
                  location: 'left',
                  title: {
                      text: 'Axis Title Y',
                      fillStyle: 'green'
                  }
              }
          ],
          series: [
              {
                  type: 'line',
                  title: 'Series 1',
                  xValuesField: 'data1',
                  yValuesField: 'value1'               	  
                  //data: [[1, 62], [2, 60], [3, 68], [4, 58], [5, 52], [6, 60], [7, 48]]
              },
              {
                  type: 'line',
                  title: 'Series 2',
                  xValuesField: 'data2',
                  yValuesField: 'value2',
                  //data: [[1, 46], [2, 40], [3, 62], [4, 65], [5, 60], [6, 36], [7, 70]]
                  markers: {               //标记
                      size: 10,
                      type: 'rectangle',
                      strokeStyle: 'black',
                      fillStyle: 'red',
                      lineWidth: 1
                 }

              }
          ]
      });	  
  }
  
     function doPieChart(){
  	  
  	   $('#jqChart1').jqChart({
             title: { text: 'Pie Chart' },
             legend: { title: 'Countries' },
             border: { strokeStyle: '#6ba851' },
             background: background,
             animation: { duration: 1 },
             dataSource :{
                 ajax: {
                     type: "POST",
                     url: "../../ssi_activity/mae/piechart",
                     data: "",
                     dataType: 'json'
                 }
             },
             shadows: {
                 enabled: true
             },
             series: [
                 {
                     type: 'pie',
                     fillStyles: ['#418CF0', '#FCB441', '#E0400A', '#056492', '#BFBFBF', '#1A3B69', '#FFE382'],
                     labels: {
                         stringFormat: '%.1f%%',
                         valueType: 'percentage',
                         font: '15px sans-serif',
                         fillStyle: 'white'
                     },
                     explodedRadius: 10,
                     dataLabelsField: 'name',
                     dataValuesField: 'value',
                     explodedField: 'exploded'
                 }
             ]
         });

         /*$('#jqChart').bind('tooltipFormat', function (e, data) {
             var percentage = data.series.getPercentage(data.value);
             percentage = data.chart.stringFormat(percentage, '%.2f%%');

             return '<b>' + data.dataItem[0] + '</b><br />' +
                    data.value + ' (' + percentage + ')';
         });*/
  	   
  	 $('#button2').show().click(function () {
         $('#jqChart').jqChart('exportToPdf');
     });
  	   
     }
     
     function doMarginsChart(){
    	 $('#jqChart').jqChart({
             title: { text: 'Axis Margins' },
             animation: { duration: 1 },
             dataSource: {
                 ajax: {
                     type: "POST",
                     url: "../../ssi_activity/mae/margin",
                     data: "",
                     dataType: 'json'
                 }
             },
             axes: [
                 {
                     type: 'linear',
                     location: 'bottom',
                     leftMargin: 0,
                     rightMargin: 0
                 },
                 {
                     type: 'linear',
                     location: 'left',
                     bottomMargin: 90,
                     topMargin: 20
                 }
             ],
             series: [
                 {
                     type: 'splineArea',           //区域式数据显示
                     title: 'Series 1',
                     xValuesField: 'key1',
                     yValuesField: 'value1'
                 },
                 {
                     type: 'splineArea',  //or 'spline' , 'stacked100Area', 'stacked100Bar', 'stacked100Column', 'stacked100Line',
                    /* 'splineRange' data: [['A', 33, 43], ['B', 57, 62], ['C', 13, 30],
                            ['D', 12, 40], ['E', 35, 70], ['F', 7, 30], ['G', 24, 30]]       参看chartTypes*/
                    
                     title: 'Series 2',
                     xValuesField: 'key2',
                     yValuesField: 'value2'
                 },
                 {
                     type: 'splineArea',
                     title: 'Series 3',
                     xValuesField: 'key3',
                     yValuesField: 'value3'
                 }
             ]
         });

    	 
     }
    
