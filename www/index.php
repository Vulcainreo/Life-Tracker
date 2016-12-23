<!DOCTYPE>

<html>

  <head>
    <title>Life Tracker</title>

    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1, maximum-scale=1">

    <script src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/vis.min.js"></script>
    <script src="./js/data.js"></script>
    <script src="./js/cytoscape.min.js"></script>
    <script src="./js/cytoscape-qtip.js"></script>
    <script src="./js/jquery.qtip.min.js"></script>
   

    <script src="./js/plot.js"></script> 
    
    <link src="./css/jquery.qtip.min.css" rel="stylesheet" type="text/css"></link>
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/vis.min.css" rel="stylesheet">
    <link href="./css/index.css" rel="stylesheet">
    

    <!-- for testing with local version of cytoscape.js -->
    <!--<script src="../cytoscape.js/build/cytoscape.js"></script>-->

    
  </head>

  <body>
      <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">LifeTr@cker</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="?context=graph">Graph</a></li>
            <li><a href="?context=timeline">Timeline</a></li>
            <li><a href="?context=map">Map</a></li>
            <li><a href="?context=dataset.html">DataSet</a></li>
          </ul>
        </div>
      </div>
    </nav>
  
    <?php
        switch ($_GET['context']) {
            case "graph":
                include("graph.html");
                break;
                
            case "timeline":
                include("timeline.html");
                break;
            default: 
                echo "Choose a context";
                break;
        }
    ?>
  </body>

</html>
