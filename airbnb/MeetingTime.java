class Solution {
    class Point implements Comparable<Point> {
        int time;
        boolean isStart;

        Point(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Point that) {
            if (this.time != that.time || this.isStart == that.isStart) {
                return this.time - that.time;
            } else {
                return this.isStart ? -1 : 1;
            }
        }
    }

    public List<Interval> getAvailableIntervals(List<List<Interval>> intervals, int k) {
        List<Interval> res = new ArrayList<>();
        List<Point> points = new ArrayList<>();

        for (List<Interval> intervalList : intervals) {
            for (Interval interval : intervalList) {
                points.add(new Point(interval.start, true));
                points.add(new Point(interval.end, false));
            }
        }
        Collections.sort(points);

        int count = 0;
        Integer availableStart = null;
        for (int i = 0; i < points.size(); i++) {
            Point point = points.get(i);
            if (point.isStart) {
                count++;
                if (availableStart == null && i == 0 && count <= intervals.size() - k) {
                    availableStart = point.time;
                } else if (availableStart != null && count == intervals.size() - k + 1) {
                    res.add(new Interval(availableStart, point.time));
                    availableStart = null;
                }
            } else {
                count--;
                if (count == intervals.size() - k && i < points.size() - 1) {
                    availableStart = point.time;
                } else if (availableStart != null && i == points.size() - 1 && count <= intervals.size() - k) {
                    res.add(new Interval(availableStart, point.time));
                    availableStart = null;
                }
            }
        }

        return res;
    }
}