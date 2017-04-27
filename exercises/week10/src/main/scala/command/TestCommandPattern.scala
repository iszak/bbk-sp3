package command

object TestCommandPattern extends App {
    val pool = new ThreadPool(10)

    val emailJob = new EmailJob
    val smsJob = new SmsJob
    val fileIOJob = new FileIOJob()
    val logJob = new LoggingJob()

    var email: Email = null
    var sms: Sms = null
    var fileIO: FileIO = null
    var logging: Logging = null

    for (i <- 0.until(5)) {
      email = new Email
      emailJob.setEmail(email)

      sms = new Sms
      smsJob.setSms(sms)

      fileIO = new FileIO
      fileIOJob.setFileIO(fileIO)

      logging = new Logging
      logJob.setLogging(logging)

      pool.addJob(emailJob)
      pool.addJob(smsJob)
      pool.addJob(fileIOJob)
      pool.addJob(logJob)
    }
    pool.shutdownPool
}
