# SimpleRefreshListView
一个很轻量级的支持下拉刷新和上拉加载更多的listview库，集成了RefreshLayout

#用法
```java
public class DemoActivity extends Activity {

    private EasyRefreshListView listView;
    private ArrayAdapter<String> adapter;
    private int refreshCount;
    private int loadMoreCount;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        handler = new Handler();
        listView = (EasyRefreshListView) findViewById(R.id.listview);
        final List<String> list = new ArrayList<>();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnPullRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.insert("pull refresh" + (++refreshCount), 0);
                        listView.setPullRefreshing(false);
                    }
                }, 3000);
            }
        });

        listView.setOnLoadMoreListener(new EasyRefreshListView.OnLoadMoreListener() {
            @Override
            public void loadMore() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.add("load more" + (++loadMoreCount));
                        if (loadMoreCount  == 4){
                            listView.onLoadCompleteNoMore(EasyRefreshListView.NoMoreHandler.NO_MORE_LOAD_SHOW_FOOTER_VIEW);
                        }else{
                            listView.onLoadComplete();
                        }
                    }
                }, 3000);
            }
        });
    }
}
