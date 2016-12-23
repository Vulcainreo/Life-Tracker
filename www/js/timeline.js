var container = document.getElementById('timeline');

  // Create a DataSet (allows two way data-binding)
  
var items = new vis.DataSet();

  // Configuration for the Timeline
  var options = {};

  // Create a Timeline
  var timeline = new vis.Timeline(container, items, options);

timelineSetupData();