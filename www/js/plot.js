function setupData() {

        cyjs.add({group: "nodes", data: {id: "moi", name: "Moi", score:0.01}, position: {x: 150, y: 150}});

        obj = JSON.parse(dataMac);
                $.each(obj, function () {
                        var rssi = (Math.abs(this.rssi)-30)*7;
                        var angle = Math.floor(Math.random()*360)+1;
                        
                        
                        posX = (Math.cos(angle))*rssi+150;
                        posY = (Math.sin(angle))*rssi+150;
              
                        //var posX = Math.floor(Math.random()*300)+1;
                        //var posY = Math.floor(Math.random()*300)+1;
                        
                        var point = {group: "nodes", data: {id: this.id, name: this.address }, position: { x: posX,y: posY}};
                        var edge = {group: "edges", data: {source: "moi", target: this.id}};
        		cyjs.add(point);
        		cyjs.add(edge);
        		//console.log(Math.abs(this.rssi));
        		
        		cyjs.$('#'+this.id).once('mouseover', function (e) {
        		        $("#info").html(e.cyTarget.data('name'));
        		      
        		});
        		
        });
        
        
}
