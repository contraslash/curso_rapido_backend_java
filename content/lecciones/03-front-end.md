Title: Front End
Author: Mauricio Collazos
Date: 2019-02-11
![]()
---
class: center, middle, light, first-slide
# Front End
## Mauricio Collazos
.footnote[]
---
# Renderizado de contenido por un navegador
- HTML
- CSS
- Javascript
---
# Preprocesadores de CSS

- [Sass](http://sass-lang.com/)
- [less](http://lesscss.org/)
- [stylus](http://stylus-lang.com/)
- [postcss](https://postcss.org/)
---
# Lógica avanzada en el cliente
- [Angular](https://angular.io/)
- [React JS](https://reactjs.org/)
- [Ember JS](https://www.emberjs.com/)
- [Vue JS](https://vuejs.org/)
- [Listado en Github](https://github.com/collections/front-end-javascript-frameworks)

---
# Vue JS
```html
<html>
    <body>
        <div id="app">
          {{ mensaje }}
        </div>
        <script src="https://cdn.jsdelivr.net/npm/vue"></script>
        <script>
            var app = new Vue({
              el: '#app',
              data: {
                mensaje: 'Hola Mundo!'
              }
            })
        </script>
    </body>
</html>
```
---
# Condicionales
```html
<html>
    <body>
        <div id="app" v-if="visible">
          {{ mensaje }}
        </div>
        
    </body>
</html>
```
---
# Ciclos
```html
<html>
    <body>
        <div id="app" >
            <ol>
                <li v-for="elemento in lista">
                    {{ elemento }}
                </li>
            </ol>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/vue"></script>
        <script>
            var app = new Vue({
              el: '#app',
              data: {
                lista: [
                    "Elemento 1",
                    "Elemento 2",
                    "Elemento 3"
                ]
              }
            });
        </script>
    </body>
</html>
```
---
# Manejo de eventos
```html
<html>
    <body>
        <div id="app" >
            <input v-model="mensaje">
            <button v-on:click="click">Mostrar</button>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/vue"></script>
        <script>
            var app = new Vue({
              el: '#app',
              data: {
                mensaje: ""
              },
              methods: {
                  click: function()
                  {
                      alert(this.mensaje);
                  }
              }
            });
        </script>
    </body>
</html>
```
---
# Acceso a API
```javascript
var app = new Vue({
  el: '#app',
  methods: {
    fetchData: function () {
      var peticion = new Request('https://jsonplaceholder.typicode.com/posts');
      var self = this;
      fetch(peticion)
        .then(function(response){
                self.lista = response.json();
                return self.lista
        }).then(function(data){
              self.lista = data;
              console.log(self.lista)
        }).catch(function(error){
                console.log(error);
        });
    }
  }
});
```
