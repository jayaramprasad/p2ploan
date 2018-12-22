function ConvertFormToJSON(form){
	
			var array = jQuery(form).serializeArray();
			
			var json = {};
			
			jQuery.each(array, function() {
				json[this.name] = this.value || '';
			});
			
			return json;
		}
		
jQuery(document).on('ready', function() {
			
			jQuery('form#contact').bind('submit', function(event){
				
				event.preventDefault();
				
				var form = this;
				
				var json = ConvertFormToJSON(form);
				alert(JSON.stringify(json));
				
				$.ajax({
					type: "POST",
					url: "http://localhost:8008/loan/v1/p2ploan",
					data: json,
					headers: {
				        'Content-Type': 'application/json',
				        'Access-Control-Allow-Origin' : '*'
				    },
				    crossDomain: false,
					dataType: "jsonp"
				}).done(function() { 
					alert("Successfully Submitted the request"); 
				}).fail( function(xhr) {
					  alert('Request Status: ' + xhr.status + ' Status Text: ' + xhr.statusText + ' Response Text ' + xhr.responseText);
					  alert('Request responseURL: ' + xhr.response);
			     });

				return true;
			});
		});