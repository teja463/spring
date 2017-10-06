<!DOCTYPE HTML>
<html>
<body>
	Time:
	<span id="foo"></span>

	<br>
	<br>
	<button onclick="start()">Start</button>
	<button onclick="stop()">Stop</button>
	<script type="text/javascript">
		var eventSource = null;
		function start() {
			eventSource = new EventSource("/test/SampleServlet3");
			eventSource.onmessage = function(event) {
				document.getElementById('foo').innerHTML += event.data+"</br>";
			};
		}
		function stop(){
			eventSource.close();
		}
	</script>
</body>
</html>