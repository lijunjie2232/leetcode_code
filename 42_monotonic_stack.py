def trap(height) -> int:
    left = len(height) - 1
    mount = 0
    st = []
    # item in st is going to be smaller
    while left >= 0:
        while st and height[st[-1]] <= height[left]:
            # a[left] is new item to push into st, a[st[-1]] is the last item pushed into st;
            # only if a[st[-1]] > a[left], the new item could be pushed into
            # so st should pop latest item fist inorder to make last item a[st[-1]] > a[left]
            tmp = st.pop()
            if not st: break# if st is empty, left is now the biggest is st
            mount += (min(height[left], height[st[-1]]) - height[tmp])*(st[-1] - left -1)

        print(mount, left)
        st.append(left)
        left -= 1


    return mount

if __name__ == '__main__':
    # data = [1,0,2,1,0,1,3,2,1,2,1]
    # print(trap(data))
    data = [4,2,0,3,2,5]
    print(trap(data))
    data = [4,2,3]
    print(trap(data))