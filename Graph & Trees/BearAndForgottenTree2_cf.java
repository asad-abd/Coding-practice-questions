// https://codeforces.com/problemset/problem/653/E
// interesting question on a optimized dfs/bfs
// concepts- spanning tree, dfs, bfs, connected graph

// Question;-
// A tree is a connected undirected graph consisting of n vertices and n - 1
// edges. Vertices are numbered 1 through n.
// Limak is a little polar bear. He once had a tree with n vertices but he lost
// it. He still remembers something about the lost tree though.
// You are given m pairs of vertices (a 1, b 1), (a 2, b 2), ..., (a m, b m).
// Limak remembers that for each i there was no edge between a i and b i. He
// also remembers that vertex 1 was incident to exactly k edges (its degree was
// equal to k).
// Is it possible that Limak remembers everything correctly? Check whether there
// exists a tree satisfying the given conditions.