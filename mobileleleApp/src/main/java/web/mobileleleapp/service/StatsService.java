package web.mobileleleapp.service;

import web.mobileleleapp.model.view.StatsView;

public interface StatsService {
  void onRequest();
  StatsView getStats();
}
