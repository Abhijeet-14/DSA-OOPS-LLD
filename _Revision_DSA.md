# DSA REVISION
<details>
    <summary>Graph</summary>
  
  ### Q1. Bellman-Ford Algo
  - **Algo:**
    - AThila
    - Ala
  - 
    <details> 
        <summary>Code:</summary>

        ```python
            fun(ad):
                return 10
        ```
    </details>
  
### Q2. Bellman-Ford Algo
  - **Algo:**
    - AThila
    - Ala
  - 
    <details> 
        <summary>Code:</summary>

        ```python
            fun(ad):
                return 10
        ```
    </details>
  
</details>

<details>
  <summary>Array</summary>
  
  ### Q1. Array

  Some text inside the collapsible section.

  - Item 1
  - Item 2
  ```python
    fun(ad):
        return 10
  ```
</details>
<details>
  <summary>String</summary>
  
  ### Q1. Array

  Some text inside the collapsible section.

  - Item 1
  - Item 2
  ```python
    fun(ad):
        return 10
  ```
</details>
<details>
  <summary>Sliding Window</summary>
  
### Q1. Longest Reapeating Substrubg of K-replacement
  - **Algo:**
    - s=AADADDA, k=2--> o/p = 5 
    - AADAD, 2 D's can be replaced
    - or DADDA, 2 A's can be replaced
    - so
    - each time -- we need max_frequency of 1 character 
    - and total minus of max_frequency --> minor character
    - this needs to be less than k. 
    - Complexity:
      - TC - O(2N) * O(26) [for new max_freq]
      - SC - O(N)
  - 
    <details> 
      <summary>Code:</summary>

        ```python
            fun(s, k):
              map = {}
              max_freq = 0
              maxi = 0
              l = 0
              for r in range(N):
                map[s[r]] += 1
                max_freq = max(map[s[r]], max_freq)

                # total - max = minor char
                while ((r-l+1) - max_freq) > k:
                  map[s[l]] -= 1
                  # new max_freq
                  for k, v in map.values():
                    max_freq = max(v, max_freq)
                  l += 1
                
                maxi = max(max_freq, maxi)

              return maxi
        ```
    </details>


### Q2. MINimum Window Substring 
  - **Algo:**
    - s = adobecodebanc, t = abc
    - o/p - 4 [banc]
    - Q: mini size substring which contain all char of t
    - here MIN is needed
    - so when we found substring which match with t -- 
    - then in that substring -- we need to find min size in which -- t is match
    - Complexity:
      - TC - O(2N) * O(M) [t and substring match]
      - SC - O(2N)
      - Optimized - O(2N)
  - 
    <details> 
      <summary>Code 1: O(2N*M)</summary>

        ```python
            fun(s, t):
              map_t = {}
              map_s = {}
              for ch in t:
                map[ch]++

              mini = N
              l = 0
              for r in range(N):
                if s[r] in map_t:
                  map_s[s[r]]++

                while map_s == map_t: # O(M)
                  mini = min(r-l+1, mini)

                  if s[l] in map_s:
                    map_s[s[l]]--
                    if map_s[s[l]] == 0: 
                      del map_s[s[l]]
                  l--
              return mini
        ```
    </details>

    <details> 
      <summary>Code 1: O(2N*1)</summary>
        use count of have & need

        ```python
            fun(s, t):
              need = {}
              need_cnt = 0 # no of keys

              have = {}
              have_cnt = 0

              for ch in t:
                need[ch]++
              
              need_cnt = len(need.keys())

              for r in range(N):
                if s[r] in need:
                  have[s[r]]++
                  if have[s[r]] >= need[s[r]]: # only incre have_cnt -> Value of char matches
                    have_cnt++
                    
                while have_cnt == need_cnt: #O(1)
                  mini = min(r-l+1, mini)
                  if s[l] in have:
                    have[s[l]]--
                    if have[s[l]] < need[s[l]]:
                      have_cnt--
                  l++

              return mini

        ```

    </details>

 
### Q3. Sliding Window MAXIMUM
  - **Algo:**
    - s=[1,3,-1,-3,5,3,6,7], k=3 --> o/p = [3,3,5,5,6,7] 
    - [1,3,-1] ->3 || [3,-1,-3] -> 3 || [-1,-3,5] = 5 ....
    - BF - O(N^2) - N loop and k lopp -- find max everytime
    - Optimize:
      - use deque (q)
      - store val[i] and if val[i] > q[-1] --> pop right
      - if l == q[0] --> pop left
    - Complexity:
      - TC - O(2N)
      - SC - O(N)
  - 
    <details> 
      <summary>Code:</summary>

        ```python
            fun(a, k):
              q = deque()
              res = []
              l = 0
              for r in range(N):
                while q and a[r] > a[q[-1]]:
                  q.pop() # pop right

                q.append(r) # store index -- help in windoe slide

                if l > q[0]:
                  q.popleft()
                
                if r + 1 >= k: # found max at q[0]
                  res.append(a[q[0]]) 
                  l++

              return res
        ```
    </details>
</details>

<details>
  <summary>Two Pointer</summary>
  
  ### Q1. Array

  Some text inside the collapsible section.

  - Item 1
  - Item 2
  ```python
    fun(ad):
        return 10
  ```
</details>
<details>
  <summary>Prefix Sum</summary>
  
  ### Q1. Array

  Some text inside the collapsible section.

  - Item 1
  - Item 2
  ```python
    fun(ad):
        return 10
  ```
</details>


<details>
    <summary>Recusrion</summary>
  
  ### Q1. Recursion

  Some text inside the collapsible section.

  - Item 1
  - Item 2
  ```python
    fun(ad):
        return 10
  ```
</details>

<details>
    <summary>Backtracking</summary>
  
  ### Q1. Recursion

  Some text inside the collapsible section.

  - Item 1
  - Item 2
  ```python
    fun(ad):
        return 10
  ```
</details>

<details>
    <summary>DP</summary>
  
  ### Q1. Recursion

  Some text inside the collapsible section.

  - Item 1
  - Item 2
  ```python
    fun(ad):
        return 10
  ```
</details>

<details>
<summary>Graph</summary>
  
### Q1. Bellman-Ford Algo
  - **Algo:**
    - Relax all edges by "N-1" times
    - Relax => update distance array if
      - if (dist[u] + wt < dist[v])
        - dist[v] = dist[u] + wt 
    - why N-1 time:
      - bcoz, in worst case -
      -  at each loop -- can find atleast 1 distance for sure
    - Negative Cycle?:
      - 1 --(-2m)--> 2 --(-1m)--> 3 --(-1m)--> 1  (all -ve)
      - so by N-1 all shortest distance must be found
      - no reduction possible -- if reduced -- Negative Cycle
    - Complexity:
      - TC - O(V*E) ~ O(N^2)
      - SC - O(V)
  - 
    <details> 
        <summary>Code:</summary>

        ```python
            fun(V, edges, src):
                dist = [INF]*V
                dist[src] = 0

                for i in range(0, V): # N-1 time
                    for u, v, wt in edges:
                        if dist[u] != INF and dist[u] + wt < dist[v]:
                            dist[v] = dist[u] + wt
                
                # negative cycle - test
                for u, v, wt in edges:
                    if dist[u] != INF and dist[u] + wt < dist[v]:
                        return -1 # not possible -- infite reduction can happend
                return dist
        ```
    </details>
  
### Q2. Disjoint-Set-Union
  - work best on **Dynamic Graph**
  - if we tell find (u,v) are of same graph -- DFS take O(V+E)
  - but, DSU takes **TC - O(1)**
  - DSU has 2 component
    - find_parent
    - union b/w (u, v)
  - **Algo:**
    - 1. find ultimate_parent of u & v (ul_par_u, ul_par_v)
    - 2. if size of ul_par_u > ul_par_v 
          - connect ul_par_v to ul_par_u
          - increase size of ul_par_u by ul_par_v
    - 3. size compress -- always update ultimate parent of a node
  
    - initially, size[1,1,1,...,1] and parent[0,1,2,3,...,N]
    - all node are self-parent and resp graph size is 1
    - Complexity:
      - TC - O(V) * O(1)
      - SC - O(V)
  - 
    <details> 
        <summary>Code:</summary>

        ```python
            class Disjoint_Set_Union:
                def __init__(N):
                    size = [1]*N
                    parent = [i for i in range(N)]
                
                def find_ulti_parent(u):
                    if parent[u] == u: # self-parent
                        return u

                    parent[u] = find_ulti_parent(parent[u])
                    return parent[u]

                def union_by_size(u, v):
                    ulti_par_u = find_ulti_parent(u)
                    ulti_par_v = find_ulti_parent(v)

                    if ulti_par_u == ulti_par_v: # same graph
                        return
                    elif size[ulti_par_u] > size[ulti_par_v]:
                        parent[ulti_par_v] = ulti_par_u  # new parent of v
                        size[ulti_par_u] += size[ulti_par_v] # v got merged to u, as child
                    else:
                        parent[ulti_par_u] = ulti_par_v
                        size[ulti_par_v] += size[ulti_par_u]
        ```
    </details>
  
### Q3. Minimum-Spanning Tree - DSU
  - Spanning Tree:
    - N nodes & N-1 edges
    - any node can travel to any node ==> in same graph
  - Minimum Spanning Tree:
    - sum of all wt - minimum
  - **Algo:**
    - DSU - connect all nodes in 1 graph
    - min # of edge
    - for Min wt:
      - sort edges by wt
      - union in DSU
    - Complexity:
      - TC - O(E*logE) + O(E)*O(1)-dsu
      - SC - O(V)
  - 
    <details> 
        <summary>Code:</summary>

        ```python
            def fun(V, edges):
                edges.sort(key= lambda x: x[2])
                dsu = Disjoint(V)
                min_sum = 0
                for u, v, wt in edges:
                    ul_p_u = dsu.find_ulti_par(u)
                    ul_p_v = dsu.find_ulti_par(v)
                    if ul_p_u != ul_p_v:
                        min_sum += wt
                        dsu.union_by_size(ul_p_u, ul_p_v)

                return min_sum
        ```
    </details>

### Q4. Number of provinces - DSU
  - tell no of connected components
  - **Algo:**
    - in DSU - we know 1 connected graph has only 1 ulitmate_parnet == self
    - if we count no of ultimate parent == self
    - we got no of connected components
    - Complexity:
      - TC - O(V)*O(1)-dsu
      - SC - O(V)
  - 
    <details> 
        <summary>Code:</summary>

        ```python
            def fun(V, edges):
                dsu = Disjoint(V)
                cnt = 0
                for node in V:
                    ul_p_node = dsu.find_ulti_par(node)
                    if ul_p_node == node: # self parent
                        cnt += 1

                return cnt
        ```
    </details>

### Q5. Min Number of Operation to make graph connected to 1 - DSU
  - Question: 
    - can have mutilple connectd compoent
    - operation: remove edge -- add that edge bw compoent
    - tell min no of ops req
  - **Algo:**
    - Dynamic Graph
    - to remove -- we need extra edge
    - to add -- # of conn compo (NC) --> if 3 conn compo is ther --> 2 edge needed
    - so, if ( extra_edge == NC -1 )
    - Complexity:
      - TC - O(V)*O(1)-dsu
      - SC - O(V)
  - 
    <details> 
        <summary>Code:</summary>

        ```python
            def fun(V, edges):
                dsu = Disjoint(V)
                extra_edge = 0

                for u, v in edges:
                    if ds.find_par(u) == ds.find_par(v): # duplicate edge
                        extra_edge += 1
                    else:
                        ds.union_by_size(u,v)

                no_conn_compo = 0
                for node in V:
                    if ds.find_par(node) == node:
                        no_conn_compo += 1
                
                if extra_edge == no_conn_compo - 1:
                    return extra_edge
                
                return -1 # not possible
        ```
    </details>

### Q6. Number of Islands 2 - DSU
  - Q: NxM grid, have queries[(0,0)(1,0)....] of cell to put 1 -- after each query tell no of island
  - **Algo:**
    - Dynamic Graph
    - in DSU we need node
    - how to convert 2D-matrix to node
      - node = row*M + col
    - when put 1 -- it can connect to 4 direction neighbour
    - 4 dir DSU
    - count + 1
    - if not same parent --> union --> count - 1
    - Complexity:
      - TC - O(N*M) + O(Q)
      - SC - O(V)
  - 
    <details> 
        <summary>Code:</summary>
    
        ```python
            def fun(N, M, grid, Q):
                dsu = Disjoint(N*M) # no of nodes
                cnt = 0
                res = []
                for r, c in Q:
                    if grid[r][c] == 1:
                        continue
                        
                    grid[r][c] = 1
                    cnt += 1 # assume its independt-island

                    for dr, dc in [(1,0),(-1,0),(0,1),(0,-1)]:
                        nr = r + dr
                        nc = c + dc

                        if is_safe(nr, nc) and grid[nr][nc] == 1:
                            u_node = r*M + c
                            v_node = r*M + c
                            if ds.find_par(u_node) != ds.find_par(v_node):
                                cnt -= 1
                                ds.union_by_size(u_node, v_node)

                    res.append(cnt)

                return res
        ```
    </details>

### Q7. Maxium Connected Group - DSU
  - Q: NxM grid, can convert only 1 cell from 0 -> 1 => tell total max size of connect component
  - 
  - **Algo:**
    - Dynamic graph --> DSU
    - 2D-matrix --> node = row*M + col
    - DSU in 2D-matrix --> union on all 4 direction
    - try all 0 to 1 --> check max total size
    - Complexity:
      - TC - O(N*M) + O(Q)
      - SC - O(V)
  - 
    <details> 
        <summary>Code:</summary>
    
        ```python
            def fun(N, M, grid, Q):
                dsu = Disjoint(N*M) # no of nodes

                # Step 1: build DSU
                for r in range(N):
                    for c in range(M):
                        if grid[r][c] == 0:
                            continue

                        u_node = r * M + c
                        for dr, dc in [(1,0),(-1,0),(0,1),(0,-1)]:
                            nr = r + dr
                            nc = c + dc
                            if is_safe(nr, nc) and grid[nr][nc]==1:
                                v = nr * M + nc
                                ds.union_by_size(u_node, v_node)

                # Step 2: check total max size
                maxi = 0
                for r in range(N):
                    for c in range(M):
                        if grid[r][c] == 1: # can only convert 0 to 1
                            continue
                        
                        parents = set() # V.V.I
                        for dr, dc in [(1,0),(-1,0),(0,1),(0,-1)]:
                            nr = r + dr
                            nc = c + dc
                            if is_safe(nr, nc) and grid[nr][nc] == 1:
                                v_node = r*M + c
                                parents.add(ds.find_parent(v_node)) # store all diff neighbour parent

                        size = 1 # for new cell 0 -> 1
                        for u in parents:
                            size += ds.size[u]

                        maxi = max(size, maxi)
                return maxi
        ```
    </details>

### Q8. Detect Cycle in Direct Graph - DFS
  - **Algo:**
    - Complexity:
      - TC - O(V+E)
      - SC - O(V)
  - 
    <details> 
        <summary>Code:</summary>
    
        ```python
            def fun(v, edges):
                rec_st = []
                vis = {}
                def detect_cycle_dfs(src):
                    vis.add(src)
                    rec_st.append(src)

                    children = graph.get(src, [])
                    for ch in children:
                        if ch not in vis:
                            if detect_cycle_dfs(ch): # child is in cycle
                                return True
                        elif ch in rec_st: # cycle
                            return True

                    rec_st.remoev(src)
                    return False # not cycle

            for i in range(V):
                if i not in vis and detect_cycle_dfs(i):
                    return True # Cycle
            return False
        ```
    </details>

### Q9. Topological Sort - DFS
  - **Algo:**
    - Complexity:
      - TC - O(V+E)
      - SC - O(V)
  - 
    <details> 
        <summary>Code:</summary>
    
        ```python
            def fun(v, edges):
                topo = []
                vis = {}
                def dfs(src):
                    vis.add(src)

                    children = graph.get(src, [])
                    for ch in children:
                        if ch not in vis:
                            dfs(ch)

                    topo.append(src)

                for i in range(V):
                    if i not in vis:
                        dfs(i)
                    
                return topo
        ```
    </details>

### Q10. Topological Sort - BFS - (In-Degree Algo)
  - **Algo:**
    - count no of in-degree to node
    - initally in Queue -- all nodes with in-deg is 0
    - travel BFS -
      - for child --> decrease in_deg
      - if in-deg == 0: add to Queue
    - Complexity:
      - TC - O(V+E)
      - SC - O(V)
  - 
    <details> 
        <summary>Code:</summary>
    
        ```python
            def fun(v, edges):
                in_deg = [0]*V
                for u, v in edges: # v has incoming from u
                    in_deg[v] += 1
                q = deque()
                for i in range(V):
                    if in_deg[i] == 0:
                        q.append(i)
                
                topo = []
                while q:
                    u = q.popleft()
                    topo.add(u)

                    for ch in graph(u):
                        in_deg[ch] -= 1 # remove 1 incoming -- as its noted
                        if in_def[ch] == 0: q.append(ch)

                return topo

            # if-cycle:
            # topo only work in Acyclic Graph -- 
            # so if topo possible -- len(topo) == V
            if len(topo) == V:
                return NOT_CYCLE
            
            return CYCLE

        ```
    </details>

### Q10. Find Eventual Safe States - BFS - Topological Sort
  - **Algo:**
    - return all safe nodes
    - safe nodes ? -- which doesn't get stuck in cycle -- exist with terminal node
    - in topo - we use in-deg...
    - here -- reverse the graph... so we will get out-degree 
    - and then store topo of out_deg
    - Complexity:
      - TC - O(V+E)
      - SC - O(V)
  - 
    <details> 
        <summary>Code:</summary>
    
        ```python
            def fun(v, edges):
                graph = {}
                reverse_graph = {}
                for u, v in edges:
                    reverse_graph[v] = reverse_graph.get(v, []) + [u]

                oun_deg = [0]*V
                for u, v in edges: # u has out-going from v
                    out_deg[u] += 1

                q = deque()
                for i in range(V):
                    if out_deg[i] == 0:
                        q.append(i)
                
                topo = []
                while q:
                    u = q.popleft()
                    topo.add(u)

                    for ch in graph(u):
                        out_deg[ch] -= 1 # remove 1 outgoing -- as its noted
                        if out_def[ch] == 0: q.append(ch)

                return topo # we need to safe nodes

        ```
    </details>

### Q11. Distance to Nearest Cell having 1 - 0/1 matrix
  - **Algo:**
    - distance of 1's cell from nearest 1 = 0
    - travel BFS - as any 1's can be nearest
    - store all 1's in Q -- dist 0 -- mark visited
    - travel BFS and increase dist by 1 if not 1
    - Complexity:
      - TC - O(N*M) + O(N*M*4)
      - SC - O(N*M)
  - 
    <details> 
        <summary>Code:</summary>
    
        ```python
            def fun(N, M, grid):
                q = deque()
                vis = [[False]*M]*N
                dis = [[0]*M]*N
                for r in range(N):
                    for c in range(M):
                        if grid[r][c] == 1:
                            q.append((r,c,0))
                            vis[r][c] = True
                            dis[r][c] = 0
                
                while q:
                    r, c, d = q.popleft()
                    for dr, dc in [(1,0),(-1,0),(0, 1),(0,-1)]:
                        nr = r + dr
                        nc = c + dc
                        if is_safe(nr, nc) and grid[nr][nc] != 1 and vis[nr][nc] == False:
                            vis[nr][nc] = True
                            dis[nr][nc] = d + 1
                            q.append((nr, nc, d + 1))

                return dis  
        ```
    </details>

### Q12. Dijkstra
  - **Algo:**
    - you know the algo
    - Complexity:
      - TC - O(V*LogE)
  - 
    <details> 
        <summary>Code:</summary>
    
        ```python
            def fun(N, M, grid):
        ```
    </details>

### Q13. Print Shortest Path
  - **Algo:**
    - you know the algo
    - whenver update distance
    - store its parent
    - Complexity:
      - TC - O(V*LogE)
    <details> 
        <summary>Code:</summary>
    
        ```python
            def fun(V, edges, src, dest):
                ... code ...

                if dist[par] + wt < dist[ch]:
                    shortest_parent[ch.v] = par.v
                ... code ...
            
            res = []
            node = dest # destination
            while shortest_parent[node] != node:
                res.append(node)
                node = shortest_parent[node]

            res.append(src)
            return res

        ```
    </details>

### Q14. No of ways to reach destination in shortest time
  - **Algo:**
    - you know the dijkstra algo
    - ways arrays [] 
    - whenver reach by shortest path -- update
      - ways[ch.v] = ways[par.v]
      - 
    - else d[par.v] + wt == d[ch.v]
      - ways[ch.v] += ways[par.v]
      - 
    - Complexity:
      - TC - O(V*LogE)
    <details> 
        <summary>Code:</summary>
    
        ```python
            def fun(V, edges, src, dest):
                ... code ...
        ```
    </details>

### Q15. Cheapest Flight with atmost K-stop
  - **Algo:**
    - ??
    - Complexity:
      - TC - O(V*LogE)
    <details> 
        <summary>Code:</summary>
    
        ```python
            def fun(V, edges, src, dest):
                ... code ...
        ```
    </details>

### Q16. Floyd-Warshall
  - **Algo:**
    - ??
    - Complexity:
      - TC - O(V*LogE)
  - <details> 
        <summary>Code:</summary>
    
        ```python
            def fun(V, edges, src, dest):
                ... code ...
        ```
    </details>

### Q17. Surrounded Regions
  - **Algo:**
    - ??
    - Complexity:
      - TC - O(V*LogE)
    <details> 
        <summary>Code:</summary>
    
        ```python
            def fun(V, edges, src, dest):
                ... code ...
        ```
    </details>

### Q17. Pacific Atlantic Water flow
  - **Algo:**
    - ??
    - Complexity:
      - TC - O(V*LogE)
    <details> 
        <summary>Code:</summary>
    
        ```python
            def fun(V, edges, src, dest):
                ... code ...
        ```
    </details>

### Q18. Most Stones Removed with Same Row or Column - DSU
  - **Algo:**
    - ??
    - Complexity:
      - TC - O(V*LogE)
    <details> 
        <summary>Code:</summary>
    
        ```python
            def fun(V, edges, src, dest):
                ... code ...
        ```
    </details>

### Q19. Rotten Oranges
  - **Algo:**
    - ??
    - Complexity:
      - TC - O(V*LogE)
  - <details> 
        <summary>Code:</summary>
    
        ```python
            def fun(V, edges, src, dest):
                ... code ...
        ```
    </details>

### Q20. Bipartite Coloring
  - **Algo:**
    - ??
    - Complexity:
      - TC - O(V*LogE)
  - <details> 
        <summary>Code:</summary>
    
        ```python
            def fun(V, edges, src, dest):
                ... code ...
        ```
    </details>

</details>

<details>
    <summary>Greedy</summary>
  
  ### Q1. Recursion

  Some text inside the collapsible section.

  - Item 1
  - Item 2
  ```python
    fun(ad):
        return 10
  ```
</details>

<details>
    <summary>Tree</summary>
  
  ### Q1. Recursion

  Some text inside the collapsible section.

  - Item 1
  - Item 2
  ```python
    fun(ad):
        return 10
  ```
</details>

<details>
    <summary>Trie</summary>
  
  ### Q1. Recursion

  Some text inside the collapsible section.

  - Item 1
  - Item 2
  ```python
    fun(ad):
        return 10
  ```
</details>
<details>
    <summary>Stack</summary>

### Q1. Area of Histogram - HARD
  - Question:
    - reactange given in x-y axis
    - each reactangle of width=1 and height is h[i]
    - find max area formed.
    - h = [2,1,5,6,2,3] o/p - 10
  - **Algo:**
    - i = 0 --> max_area = 2*1 (h*w) = 2
    - i = 1 --> max_area = max[1 (h[1]*1), 2(h[0]*1), 1*2(h=min(h[1], h[0]), w=(1-0 + 1))] = 2
    - i = 2 --> max_area = max[5, 1*2 (min(1,5), 2-1+1)] = 5
    - i = 3 --> max_area = max[6, 5*2 (min(5,6), 3-2+1)] = 10
    - so we need to put (h[i], i) in stack
    - if h[i] > st[-1][0] --> insert to st --> cal max_area
    - else: --> find_min h --> cal max_area
    - Complexity:
      - TC - O(2N) * O(26) [for new max_freq]
      - SC - O(N)
  - 
    <details> 
      <summary>Code:</summary>

        ```python
            fun(a):
              max_area = 0
              st = []

              for i, h in enumerate(a):
                start = i
                while st and st[-1][0] > h:
                  j, old_h = st.pop()

                  # h is minimum  & i-j+1 is width
                  max_area = max( h*(i-j+1) , max_area)
                  start = j # new width of min h

                st.append((h, start))

              while st: # st not empty -- check for all min h with its width 
                i, h = st.pop()
                max_area = max( h*(N-i) , max_area) # N-i - mean h is min in this region

              return max_area
        ```
    </details>

</details>
<details>
    <summary>Linked-List</summary>
  
  ### Q1. Recursion

  Some text inside the collapsible section.

  - Item 1
  - Item 2
  ```python
    fun(ad):
        return 10
  ```
</details>
<details>
    <summary>Heap</summary>
  
  ### Q1. Recursion

  Some text inside the collapsible section.

  - Item 1
  - Item 2
  ```python
    fun(ad):
        return 10
  ```
</details>
<details>
    <summary>Binary Search</summary>
  
  ### Q1. Recursion

  Some text inside the collapsible section.

  - Item 1
  - Item 2
  ```python
    fun(ad):
        return 10
  ```
</details>
<details>
    <summary>Advanced - Segment | Fenwick | Bit Manipulation</summary>
  
  ### Q1. Recursion

  Some text inside the collapsible section.

  - Item 1
  - Item 2
  ```python
    fun(ad):
        return 10
  ```
</details>