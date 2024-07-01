# mat = [[1, 2, 3, 4, 5], [6, 7, 8, 9, 10], [11, 12, 13, 14, 15], [16, 17, 18, 19, 20]]
mat = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]


def print_mat(mat):
    for row in mat:
        print("[", end="")
        for col in row:
            print(col, end=",")
        print("]")
    print()


def brute_force(mat):
    """
    1. Create MxN copy matrix
    2. then travel from 0->N & 0->M
    3. put it to copy[j][N-1-i]=mat[i][j]

    TC - O(N*M)
    SC - O(N*M)
    """
    N = len(mat)
    M = len(mat[0])
    copy_mat = [[0] * N for _ in range(M)]

    print_mat(mat)
    for i in range(0, N):
        for j in range(0, M):
            copy_mat[j][N - 1 - i] = mat[i][j]
            # copy_mat[j][N - 1 - i] = mat[i][j]

    print_mat(copy_mat)
    # return copy_mat


def optimize(mat):
    """
    1. make transpose of mat
    2. horizontal rotation

    TC - 2*(M*N)
    SC - O(1)
    """
    N = len(mat)
    M = len(mat[0])
    print_mat(mat)

    def swap(val1, val2):
        return val2, val1

    # Transpose
    for i in range(N):
        for j in range(i):
            mat[i][j], mat[j][i] = swap(mat[i][j], mat[j][i])

    # Horizontal Rotation
    for i in range(N):
        for j in range(M // 2):
            mat[i][j], mat[i][M - 1 - j] = swap(mat[i][j], mat[i][M - 1 - j])

    print_mat(mat)


brute_force(mat)
# optimize(mat)


{
    "review": [
        {
            "review_id": 1,
            "profile_img": "https://google.com",
            "profile_name": "Mary Anna",
            "profile_location": "US",
            "created_at": "2013-08-21",
            "content": "Lorem is the rgea ghosh tehgei",
            "rating1": 4,
            "rating2": 3,
            "rating3": 2,
            "rating4": 1
        },
        {
            "review_id": 2,
            "profile_img": "https://google.com",
            "profile_name": "John Jor",
            "profile_location": "UK",
            "created_at": "2024-08-21",
            "content": "Lorem is the rgea ghosh tehgei",
            "rating1": 4,
            "rating2": 3,
            "rating3": 2,
            "rating4": 1
        },
    ]
}
