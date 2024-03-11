def trap(height) -> int:
    right = len(height) - 1
    left = 0
    max_l = height[left]
    max_r = height[right]
    mount = 0
    while left < right:
        max_l = max(height[left], max_l)
        max_r = max(height[right], max_r)
        if max_l < max_r:
            mount += max_l - height[left]
            left += 1
        else:
            mount += max_r - height[right]
            right -= 1

    return mount

if __name__ == '__main__':
    data = [1,0,2,1,0,1,3,2,1,2,1]
    print(trap(data))
    data = [4,2,0,3,2,5]
    print(trap(data))
    data = [4,2,3]
    print(trap(data))