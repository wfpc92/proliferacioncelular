package LogicaNegocio;


public class Grafo<T>{
	private ListaVertice<T> lista_vertices=new ListaVertice<>();
	private ListaArco<T> lista_arcos=new ListaArco<>();
	public int costo1;
	 Grafo(){	
	}

	public ListaVertice<T> getLista_vertices() {
		return lista_vertices;
	}

	public void setLista_vertices(ListaVertice<T> lista_vertices) {
		this.lista_vertices = lista_vertices;
	}

	public ListaArco<T> getLista_arcos() {
		return lista_arcos;
	}

	public void setLista_arcos(ListaArco<T> lista_arcos) {
		this.lista_arcos = lista_arcos;
	}
	
	public void AgregarVertice(int info,int sub){
		Vertice obj=new Vertice();
		obj.setInfo(info);
		obj.setSubindice(sub);
		lista_vertices.Anex_lista(obj);
		
	}
	
	public void AgregarArco(int vi,int vj, int costo){
		Arco<T> obj_arco=new Arco<>(vi,vj,costo);
		if(lista_vertices.BuscarVertice(vi, lista_vertices)&& lista_vertices.BuscarVertice(vj, lista_vertices)){
			lista_arcos.Anex_lista(obj_arco);
		}
		else{
			System.out.println("NO ES POSIBLE AGREGAR EL ARCO ");
		}
		
	}
	
	public void ElimVertice(int subindice){
		int posicion;
		
		if(lista_vertices.BuscarVertice(subindice, lista_vertices)){
			if(!lista_arcos.EsVacio()){
				lista_arcos.Primero();
				
				while(!lista_arcos.finLista()){
					if(lista_arcos.getVentana().getArco().getVi()==subindice || lista_arcos.getVentana().getArco().getVj()==subindice){
						lista_arcos.ElimLista();
					}
					else{
						lista_arcos.setVentana(lista_arcos.getVentana().getSte());
					}
				}
				lista_arcos.ultimoLista();
				if(lista_arcos.getVentana().getArco().getVi()==subindice || lista_arcos.getVentana().getArco().getVj()==subindice){
					lista_arcos.ElimLista();
				}
			}
			
			posicion=lista_vertices.PosicionVertice(subindice, lista_vertices);
			lista_vertices.Primero();
			lista_vertices.posLista(lista_vertices, posicion, 0);
			lista_vertices.ElimLista();
		}
		else{
			System.out.println("EL VERTICE NO EXISTE");
		}
	}
	
	public void ElimArco(int vi,int vj){
		
		int posicion;
		
		posicion=lista_arcos.PosicionArcoCompleto(vi, vj, lista_arcos);
		if(posicion!=-1){
			lista_arcos.Primero();
			lista_arcos.posLista(lista_arcos, posicion, 0);
			lista_arcos.ElimLista();
		}
		else{
			System.out.println("EL ARCO NO EXISTE");
		}
	}
	
	public int CostoArco(int vi,int vj) {
		lista_arcos.Primero();
		NodoArco<T> p=lista_arcos.getCabeza();
		if(!lista_arcos.EsVacio()){
			while(!lista_arcos.finLista()){
				if(lista_arcos.getVentana().getArco().getVi()==vi && lista_arcos.getVentana().getArco().getVj()==vj){
					return lista_arcos.getVentana().getArco().getCosto();
				}
				p=p.getSte();
				lista_arcos.setVentana(lista_arcos.getVentana().getSte());
			}
			lista_arcos.ultimoLista();
			if(lista_arcos.getVentana().getArco().getVi()==vi && lista_arcos.getVentana().getArco().getVj()==vj){
				return lista_arcos.getVentana().getArco().getCosto();
			}
			else{
				return -1;
			}
		}
		else{
			return -1;
		}	
	}
	
	public int InfoVertice(int v){
		lista_vertices.Primero();
		NodoVertice<T> p=lista_vertices.getCabeza();
		if(!lista_vertices.EsVacio()){
			while(!lista_vertices.finLista()){
				if(lista_vertices.getVentana().getVertice().getSubindice()==v){
					return lista_vertices.getVentana().getVertice().getInfo();
				}
				p=p.getSte();
				lista_vertices.setVentana(lista_vertices.getVentana().getSte());
			}
			lista_vertices.ultimoLista();
			if(lista_vertices.getVentana().getVertice().getSubindice()==v){
				return lista_vertices.getVentana().getVertice().getInfo();
			}
			else{
				return -1;
			}
		}
		else{
			return -1;
		}	
	}
	
	public Lista<T> Sucesores(int vi, Lista<T> sucesores){
		
		lista_arcos.Primero();
		NodoArco<T> p=lista_arcos.getCabeza();
		if(!lista_arcos.EsVacio()){
			while(!lista_arcos.finLista()){
				if(lista_arcos.getVentana().getArco().getVi()==vi){
					sucesores.anexarLista(lista_arcos.getVentana().getArco().getVj());
				}
				p=p.getSte();
				lista_arcos.setVentana(lista_arcos.getVentana().getSte());
			}
			lista_arcos.ultimoLista();
			if(lista_arcos.getVentana().getArco().getVi()==vi){
				sucesores.anexarLista(lista_arcos.getVentana().getArco().getVj());
			}
		}
		return sucesores;
	}
	
	public int ordenGrafo(){
		return lista_vertices.LongLista();
	}
	
	public void MarcarVertice(Grafo<T> g,int subindice){
		lista_vertices.BuscarVertice(subindice, lista_vertices);
		lista_vertices.getVentana().getVertice().setMarca(true);
	}
	
	public void DesmarcarVertice(Grafo<T> g,int subindice){
		lista_vertices.BuscarVertice(subindice, lista_vertices);
		lista_vertices.getVentana().getVertice().setMarca(false);
	}
	
	public boolean MarcadoVertice(Grafo<T>g, int subindice){
		lista_vertices.BuscarVertice(subindice, lista_vertices);
		return lista_vertices.getVentana().getVertice().getMarca();
	}
	
	public void DesmarcarGrafo(Grafo<T> g){
		g.getLista_vertices().Primero();
		while(!g.getLista_vertices().finLista()){
			g.getLista_vertices().getVentana().getVertice().setMarca(false);
			g.getLista_vertices().Siguiente_lista(); 
		}
		g.getLista_vertices().ultimoLista();
		g.getLista_vertices().getVentana().getVertice().setMarca(false);
	}
	
	public Lista<T> Camino(Grafo<T>g, int v1, int v2){
		int menor;
		Lista<T> suc=new Lista<>();
		Lista<T> resp1=new Lista<>();
		Lista<T> resp2=new Lista<>();
		
		if(v1==v2){
			costo1=0;
			resp2.insertarLista(v1);
			return resp2;
		}
		else{
			suc=g.Sucesores(v1, suc);
			if(!suc.EsVacio()){
				g.MarcarVertice(g, v1);
				for(menor=-1,suc.primeroLista();!suc.finLista();suc.siguienteLista()){
					if(!g.MarcadoVertice(g, suc.infoLista())){
						resp1=Camino(g,suc.infoLista(),v2);
						if(costo1!=-1){
							costo1=costo1+g.CostoArco(v1, suc.infoLista());
							if(menor==-1 || costo1<menor){
								menor=costo1;
								resp2=resp1;
							}
							else{
								resp1=null;
							}
						}
					}
				}
				suc.ultimoLista();
				if(!g.MarcadoVertice(g, suc.infoLista())){
					resp1=Camino(g,suc.infoLista(),v2);
					if(costo1!=-1){
						costo1=costo1+g.CostoArco(v1, suc.infoLista());
						if(menor==-1 || costo1<menor){
							menor=costo1;
							resp2=resp1;
						}
						else{
							resp1=null;
						}
					}
				}
				g.DesmarcarVertice(g,v1);
				costo1=menor;
				if(costo1!=-1){
					resp2.primeroLista();
					resp2.insertarLista(v1);
				}
			}
			
			return resp2;
		}
	}
	
	public int SiguienteVertice(Grafo<T> g,int costo[],int num_elem){
		
		int i,menor=-1;
		for(i=0;i<num_elem;i++){
			if(!g.MarcadoVertice(g, i+1) && costo[i]!=-1){
				if(menor==-1 || costo[menor]>costo[i]){
					menor=i;
				}
			}
		}
		if(menor==-1){
			return -1;
		}
		else{
			return menor+1;
		}
	}
	

	public int[] Dijkstra(Grafo<T> g, int v){
		int c,i,num_elem=g.ordenGrafo();
		int costo_dij[]=new int[100];
		g.DesmarcarGrafo(g);
		g.getLista_vertices().Primero();
		for(i=0;i<num_elem;i++){
			costo_dij[i]=g.CostoArco(v,i+1);
		}
			g.MarcarVertice(g, v);
			costo_dij[v-1]=0;
			while((v=g.SiguienteVertice(g, costo_dij, num_elem))!=-1){
				g.MarcarVertice(g, v);
				for(i=0;i<num_elem;i++){
					if(!g.MarcadoVertice(g, i+1) && (c=g.CostoArco(v, i+1))!=-1){
						if(costo_dij[i]==-1){
							costo_dij[i]=costo_dij[v-1]+c;
						}
						else{
							costo_dij[i]=min(costo_dij[i],costo_dij[v-1]+c);
						}
					}
				}
			}
		
		return costo_dij;
	}
	 public int min(int a,int b){
		 if(a<b){
			 return a;
		 }
		 else{
			 return b;
		 }
	 }
	
}
