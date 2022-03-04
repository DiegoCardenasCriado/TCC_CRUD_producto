<template>
    <div id="EditarProductos">
        <!-- Modal Productos -->
        <div class="modal fade" id="modalEditarProducto" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">    
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Editar usuario</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div>
                            <input type="hidden" v-model="id">
                            <div class="form-floating mb-2">
                                <input type="text" class="form-control" id="nombre" v-model="nombre" placeholder="nombre">
                                <label for="nombre">Nombre</label>
                            </div>
                            <div class="form-floating mb-2">
                                <input type="text" class="form-control" id="descripcion" v-model="descripcion" placeholder="descripcion">
                                <label for="descripcion">Descripción</label>
                            </div>
                            <div class="form-floating mb-2">
                                <input type="text" class="form-control" id="categoria" v-model="categoria" placeholder="Categoría">
                                <label for="descripcion">Categoría</label>
                            </div>                              
                            <div class="form-floating mb-2">
                                <input type="number" class="form-control" id="precio_compra" v-model="precio_compra" placeholder="precio_compra">
                                <label for="precio_compra">Precio de compra</label>
                            </div>
                            <div class="form-floating mb-2">
                                <input type="number" class="form-control" id="precio_venta" v-model="precio_venta" placeholder="precio_venta">
                                <label for="precio_venta">Precio de venta</label>
                            </div>                            
                            <div class="form-floating mb-2">
                                <input type="text" class="form-control" id="num_lote" v-model="num_lote" placeholder="num_lote">
                                <label for="num_lote">Num. Lote</label>
                            </div>
                            <div class="form-floating mb-2">
                                <input type="number" class="form-control" id="cantidad" v-model="cantidad" placeholder="cantidad">
                                <label for="cantidad">Cantidad</label>
                            </div>
                            <div class="form-floating mb-2">
                                <input type="text" class="form-control" id="origen" v-model="origen" placeholder="origen">
                                <label for="origen">Origen</label>
                            </div>                                                        
                        </div>                           
                    </div>             
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        <button type="button" @click="Modificar()" class="btn btn-primary" data-bs-dismiss="modal">Modificar</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Agregamos componente TOAST para las notificaciones push -->
        <Toast ref="toast" />    
    </div>
</template>

<script>
// Importamos axios para las peticiones a la api
import axios from 'axios'
// Importamos el componente para las notificaciones push (Toast) 
import Toast from '../Toast.vue'

export default {
    name:'EditarProducto',
    components:{
      Toast
    },
    data() {
    return {
      id:0,
      nombre:'',
      categoria:'',
      descripcion:'',      
      precio_compra:'',
      precio_venta:'',
      num_lote:'',
      cantidad:'',
      origen:'',      
      listData:[]
    }
  },
    methods: {       
    Modificar:function(){
      let data = {
          nombre: this.nombre,
          categoria: this.categoria,
          descripcion:this.descripcion,                
          precio_compra: this.precio_compra,
          precio_venta:  this.precio_venta,
          num_lote: this.num_lote,
          cantidad:  this.cantidad,
          origen:  this.origen                           
      };

      axios.put('http://localhost:9000/api/producto/'+this.id,data).then(() =>{
        this.$emit('eventoHijo');
        this.$refs.toast.Toast("Modificado","Se modificado con exito!","success"); 
      })
      .catch(()=>{
        this.$refs.toast.Toast("Error","No se pudo modificar","error"); 
      })
      
    },
    FindByid:function(id){
      // metodo para consutlar por el id del boton editar en la vista
      axios.get('http://localhost:9000/api/producto/'+id).then(result =>{
        this.id = result.data.id;
        this.nombre = result.data.nombre;
        this.categoria = result.data.categoria;
        this.descripcion = result.data.descripcion;
        this.precio_compra = result.data.precio_compra;
        this.precio_venta = result.data.precio_venta;
        this.num_lote = result.data.num_lote;
        this.cantidad = result.data.cantidad;
        this.origen = result.data.origen;
      })
      .catch(()=>{
        this.$refs.toast.Toast("Error","Intente de nuevo","Warning"); 
      })
    }
    },
}
</script>