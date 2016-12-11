var cyjs;

$(function(){

cyjs = cytoscape({
          container: document.getElementById('cy'),
          boxSelectionEnabled: false,
          autounselectify: true,

     style: [ // the stylesheet for the graph
      {
      selector: 'node',
      style: {
        'background-color': '#666',
        'label': 'data(name)',
        "width":"mapData(score, 0, 0.01, 20, 60)",
        "height":"mapData(score, 0, 0.01, 20, 60)"
      }},
       {
      selector: 'edge',
      style: {
        'width': 3,
        'line-color': '#ccc',
        'target-arrow-color': '#ccc',
        'target-arrow-shape': 'triangle'
      }
    }
  ],

          layout: {
            name: 'cose',
            idealEdgeLength: 100,
            nodeOverlap: 20
          }
	

        });

	setupData();
	
});
