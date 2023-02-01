fetch('http://localhost:8080/lista_endpoint')
  .then(response => response.json())
  .then(data => {
    const select = document.getElementById("endpoints");
    data.forEach(item => {
      const option = document.createElement('option');
      option.value = item.endpoint;
      option.text = item.name;
      select.add(option);
    });
  });