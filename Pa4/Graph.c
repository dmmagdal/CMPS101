// Graph.c
// Array of List implementation of Graph ADT

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "List.h"
#include "Graph.h"


// structs

// private GraphObj type
typedef struct GraphObj{
	int size;
	int order;
	List[size+1] vertex;
} GraphObj;


// Constructor-Destructor

// newGraph()
// returns reference to new GraphObj representing a graphe with n vertices and no edges
Graph newGraph(int n){
	Graph G = malloc(sizeof(GraphObj));
	G->order = n;
	G->size = 0;
	for (int i = 1; i <= n; i++){
		G->vertex[i] = newList();
	}
	return(G)
}

// freeGraph()
// frees all dynamic memory associated with the Graph *pG and sets the handle *pG to NULL
void freeGraph(Graph* pG){
	if (pG != NULL && *pG != NULL){
		for (int i = 0; i <= size; i++){
			if (length(pG->vertex[i]) != 0){
				clear(pG->vertex[i]);
			}
			freeList(pG->vertex[i]);
		}
		free(*pG);
		*pG = NULL;
	}
}


// Access functions

// getOrder()
// return the order of the graph
// pre: none
int getOrder(Graph G){
	if (G == NULL){
		fprintf(stderr, "Graph Error: Calling getOrder() on NULL Graph reference\n");
		exit(1);
	}
	return(order);
}

// getSize()
// return the size of the graph
// pre: none
int getSize(Graph G){
	if (G == NULL){
		fprintf(stderr, "Graph Error: Calling getSize() on NULL Graph reference\n");
		exit(1);
	}
	return(size);
}

// getSource()
// return the source vertex most recently used in BFS() or NIL if BFS has not yet been called
// pre: 1 <= u <= getOrder(G)
int getSource(Graph G){
	if (G == NULL){
		fprintf(stderr, "Graph Error: Calling getSource() on NULL Graph reference\n");
		exit(1);
	}
	else if (u >= 1 && u <= getOrder(G)){

	}
}

// getParent()
// returns the distance from the most recent BFS source to vertex u or INF if BFS() has not yet been called
// pre: 1 <= u <= getOrder(G)
int getParent(Graph G, int u){
	if (G == NULL){
		fprintf(stderr, "Graph Error: Calling getParent() on NULL Graph reference\n");
		exit(1);
	}
	else if (u >= 1 && u <= getOrder(G)){

	}
}

// getDist()
// returns the distance from the most recent BFS source to vertex u or INF if BFS() has not yet been called
// pre: 1 <= u <= getOrder(G)
int getDist(Graph G, int u){
	if (G == NULL){
		fprintf(stderr, "Graph Error: Calling getDist() on NULL Graph reference\n");
		exit(1);
	}
	else if (u >= 1 && u <= getOrder(G)){

	}
}

// getPath()
// appends to the List L the vertices of the shortest path in G from source u or appends to L the value NIL if no such path exists
// pre: getSource(G) != NIL, BFS() must be called before getPath()
void getPath(List L, Graph G, int u){
	if (L == NULL) {
		fprintf(stderr, "Graph Error: Calling addEdge() on NULL List reference\n");
		exit(1);
	}
	else if (G == NULL){
		fprintf(stderr, "Graph Error: Calling getPath() on NULL Graph reference\n");
		exit(1);
	}
	else if (getSource(G) != NIL){

	}
}


// Manipulation Procedures

// makeNull()
// deletes all edges of G, setting graph to no edge state
// pre: none
void makeNull(Graph G){
	if (G == NULL){
		fprintf(stderr, "Graph Error: Calling makeNull() on NULL Graph reference\n");
		exit(1);
	}
	else {
		while (){

			G->size--;
		}
	}
}

// addEdge()
// insert a new edge required to maintain these lists in sorted order by increasing labels
// pre: 1 <= u, v <= getOrder(G)
void addEdge(Graph G, int u, int v){
	if (G == NULL){
		fprintf(stderr, "Graph Error: Calling addEdge() on NULL Graph reference\n");
		exit(1);
	}
	else if (u >= 1 && u <= getOrder(G) && v >= 1 && v <= getOrder(G)){
		
		G->size++;
	}
}

// addArc()
// insert a new directed edge from u to v (ie. v is added to the adjacency List of U but not u to the adjacency List of v)
// pre: 1 <= u, v <= getOrder(G)
void addArc(Graph G, int u, int v){
	if (G == NULL){
		fprintf(stderr, "Graph Error: Calling addArc() on NULL Graph reference\n");
		exit(1);
	}
	else if (u >= 1 && u <= getOrder(G) && v >= 1 && v <= getOrder(G)){
		append(G->vertex[u], v);
		G->size++;
	}
}

// BFS()
// runs breadth first search algorithm on the Graph G with source s, setting the color, distance, parent, and source fields of G to the file pointed to by out
void BFS(Graph G, int s){
	if (G == NULL){
		fprintf(stderr, "Graph Error: Calling BFS() on NULL Graph reference\n");
		exit(1);
	}
	else{
		
	}
}


// Other Operations

// printGraph()
// prints data elements in graph to out
// pre: none
void printGraph(FILE* out, Graph G){
	if (G == NULL){
		fprintf(stderr, "Graph Error: Calling printGraph() on NULL Graph reference\n");
		exit(1);
	}
	else{
		for (int i = 1; i <= getSize(G); i++){
			fprintf(out, "%d: ", i);
			printList(out, G->vertex[i]);
			fprintf(out, "\n");
		}
	}
}