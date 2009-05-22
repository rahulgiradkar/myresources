
// Cop Car conf
blueIcon = new GIcon(G_DEFAULT_ICON);
blueIcon.image = "http://gmaps-samples.googlecode.com/svn/trunk/markers/blue/blank.png";
var markerOptions = { icon:blueIcon };

//Carrega Cop Car Array
var dataBaseCars;
var copCars = new Array(); 

/*copCars[0] = new GMarker(new GLatLng(-3.832997, -38.504215), markerOptions);
copCars[1] = new GMarker(new GLatLng(-3.843889, -38.513215), markerOptions);
copCars[2] = new GMarker(new GLatLng(-3.854776, -38.525214), markerOptions);
copCars[3] = new GMarker(new GLatLng(-3.865665, -38.537213), markerOptions);*/


function resultado(resulta){	
	dataBaseCars = eval(resulta);	
	for (mark in copCars){
		map.removeOverlay(copCars[mark]);
	}
	for (mark in dataBaseCars){		
		car = dataBaseCars[mark];
		copCars[mark] = new GMarker(new GLatLng(car.localizacao.latitude, car.localizacao.longitude), markerOptions);
		map.addOverlay(copCars[mark]);
	}
}

/* Preenche os dados vindos do JSon para a variavel GMark */
function renderCars(){
	Veiculo.getPosition(resultado);
	setTimeout("renderCars()",5000);
	/*for (mark in copCars){		
		map.addOverlay(copCars[mark]);
	}*/		
}