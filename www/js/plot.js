function cySetupData() {

        cyjs.add({group: "nodes", data: {id: "moi", name: "Moi", score:0.01}, position: {x: 150, y: 150}});

        obj = JSON.parse(dataMac);
                $.each(obj, function () {
                        var rssi = (Math.abs(this.rssi)-30)*7;
                        var angle = Math.floor(Math.random()*360)+1;
                        
                        
                        posX = (Math.cos(angle))*rssi+150;
                        posY = (Math.sin(angle))*rssi+150;
              
                        var point = {group: "nodes", data: {id: this.id, name: this.address, address:this.address, rssi:this.rssi }, position: { x: posX,y: posY}};
                        var edge = {group: "edges", data: {source: "moi", target: this.id}};
                        cyjs.add(point);
        		cyjs.add(edge);
        		//console.log(Math.abs(this.rssi));
        		
        		cyjs.$('#'+this.id).on('click', function (e) {
        		        $("#macName").html(e.cyTarget.data('name'));
                                $("#macAddress").html(e.cyTarget.data('address'));
                                $("#macRssi").html(e.cyTarget.data('rssi'));
                                $("#macGpsLong").html(e.cyTarget.position('x'));
                                $("#macGpsLat").html(e.cyTarget.position('y'));
        		      
        		});
        		
        });
        
        
}

function timelineSetupData() {
    obj = JSON.parse(dataMacTimeline);
                $.each(obj, function () {
                                               
                        id = this.id;
                        content = this.address;
                        
                        $.each(this.time, function () {
                            items.add({id:id, content:content, start:this.start, end:this.end});
                        });

        });
}
