var cyjs;

$(function(){

cyjs = cytoscape({
          container: document.getElementById('cy'),

elements: [ // list of graph elements to start with
    { // node a
      data: { id: 'a' }
    },
    { // node b
      data: { id: 'b' }
    },
    { // edge ab
      data: { id: 'ab', source: 'a', target: 'b' }
    }
  ],

  style: [ // the stylesheet for the graph
    {
      selector: 'node',
      style: {
        'background-color': '#666',
        'label': 'data(id)'
      }
    },

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

setTimeout(function(){
	cyjs.add({
	    group: "nodes",
	    data: { weight: 75 },
	    position: { x: 200, y: 200 }
	});
},3000);
});
