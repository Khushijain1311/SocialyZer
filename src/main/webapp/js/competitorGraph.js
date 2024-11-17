var options = {
  chart: {
    type: 'line',
    height: 350
  },
  series: [{
    name: 'Series 1',
    data: [30, 40, 35, 50, 49, 60, 70, 91, 125]
  }, {
    name: 'Series 2',
    data: [10, 20, 15, 30, 29, 40, 50, 81, 105]
  }],
  xaxis: {
    categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep']
  }
};

var chart = new ApexCharts(document.querySelector("#graph3"), options);
chart.render();


function closed()
{
  const element=document.getElementsByClassName("side-nav")[0];
  console.log(element);
  const menu= document.getElementsByClassName("small-menu")[0];
  console.log(menu);
  element.style.display="none";
  

}

function show()
{

  const element=document.getElementsByClassName("side-nav")[0];
element.style.display="block";
 
  

  }
