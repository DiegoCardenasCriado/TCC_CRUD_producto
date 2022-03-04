<template>
  <div class="container">    
    <div class="producto">
        <div class="table-responsive">
            <button class="btn btn-outline-secondary m-1" id="btnAgregarCategoria" data-bs-toggle="modal" data-bs-target="#modalGuardarProducto">Agregar <fa icon="plus-circle" /></button>
            <table class="table table-hover table-striped caption-top text-center">
              <caption><strong>Listado de Productos</strong></caption>
              <thead class="table-dark" >
                <tr>
                  <th scope="col">Nombre</th>
                  <th scope="col">Descripción</th>
                  <th scope="col">Categoría</th>
                  <th scope="col">Precio venta</th>
                  <th scope="col">Precio compra</th>
                  <th scope="col">Num. Lote</th>
                  <th scope="col">Cantidad</th>
                  <th scope="col">Origen</th>
                  <th scope="col">Acciones</th>
                </tr>
              </thead>
                        <tbody>
                <tr v-for="item in listData" :key="item.id">
                <td>{{item.nombre}}</td>
                <td>{{item.descripcion}}</td>
                <td>{{item.categoria}}</td>
                <td>{{item.precio_venta}}</td>
                <td>{{item.precio_compra}}</td>
                <td>{{item.num_lote}}</td>
                <td>{{item.cantidad}}</td>
                <td>{{item.origen}}</td>             
                <!-- Botones para las acciones -->
                <td>
                  <div>
                    <!-- Editar -->
                    <button type="button" class="btn btn-outline-success btn-sm m-md-1" id="btnEditarCategoria"><fa icon="edit" /></button>
                    <!-- Eliminar -->
                    <button type="button" class="btn btn-outline-danger btn-sm" id="btnEliminarCategoria"><fa icon="trash-alt" /></button>            
                  </div>
                </td>
                </tr>
              </tbody>
            </table>
            <!-- Alert para mostrar cuando no hay datos -->
            <div v-if='(listData == "" )' class="alert alert-warning" role="alert">
              <strong><fa icon="exclamation-triangle" />  No hay</strong> Registros en la base de datos o <strong> <fa icon="bomb" /> se perdio</strong> la conexión con la api
            </div>
        </div>
    </div>
    <!-- Agregamos el modal para guardar Productos -->
    <ModalGuardarProducto @eventoHijo="loadData"/>
    <!-- Agregamos componente TOAST para las notificaciones push -->
    <Toast ref="toast" />   
  </div>   
</template>

<script>

// Importamos axios para las peticiones a la api
import axios from 'axios'
// Importamos los modales 
import ModalGuardarProducto from '@/components/producto/ModalGuardarProducto.vue'
// Importamos el componente para las notificaciones push (Toast) 
import Toast from '@/components/Toast.vue'

export default {
  name: 'HelloWorld',
  components:{
    ModalGuardarProducto,
    Toast
  },
  data() {
    return {
      listData:[]
    }
  },
  created() {
    this.loadData();
  }, methods: { 
       
    loadData:function(){
      axios.get('http://localhost:9000/api/producto').then(result =>{
        this.listData = result.data

      })
      .catch(()=>{
        this.listData = []
      })
    },
  },      
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
