/**
 * @param {Function} fn
 */
function memoize(fn) {
    const obj = {};
    return function(...args) {
        const key = args.toString();
        if (obj.hasOwnProperty(key)) {
            return obj[key];
        } else {
            obj[key] = fn.apply(this, args);
            return obj[key];
        }
    }
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */