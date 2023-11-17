var isAnagram = function(s, t) {
  if (s.length !== t.length) return false;
  let counter = Array.from({length: 26}, () => 0);
  for (let char of s) {
    counter[char.charCodeAt(0) - 'a'.charCodeAt(0)]++;
  }
  for (let char of t) {
    counter[char.charCodeAt(0) - 'a'.charCodeAt(0)]--;
  }
  for (let count of counter) {
    if (count !== 0) return false;
  }
  return true;
};